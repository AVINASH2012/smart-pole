package com.havells.platform.provider.chirpstack.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.havells.platform.common.MessageConstants;
import com.havells.platform.exception.ChirpStackClientException;
import com.havells.platform.exception.GatewayAlreadyExistException;
import com.havells.platform.model.GatewayRegistration;
import com.havells.platform.provider.chirpstack.client.response.Gateway;
import com.havells.platform.request.GatewayRegRequest;
import com.havells.platform.response.GatewayResponse;

public class GatewayClient {
	@Autowired
	public RestTemplate restTemplate;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// TODO move to provider client code / intercepter

	private HttpHeaders setHeader() {
		HttpHeaders header = new HttpHeaders();
		header .add("Grpc-Metadata-Authorization", MessageConstants.APIKey);
		return header;
	}

	/**
	 * @param request
	 * @return
	 * @throws ChirpStackClientException
	 * @throws GatewayAlreadyExistException
	 */
	public GatewayResponse gatewayRegistration(GatewayRegistration request)
			throws ChirpStackClientException, GatewayAlreadyExistException {
		GatewayResponse gatewayResponse = new GatewayResponse();
		// TODO Create a method in provider code where the Rest template will be moved

		HttpEntity<GatewayRegRequest> entityReq = new HttpEntity<GatewayRegRequest>(new GatewayRegRequest(request),
				setHeader());
		try {

			String gatewayURI = MessageConstants.API_URI + MessageConstants.GATEWAY_PRIMARY;
			ResponseEntity<Gateway> gatewayRegistrationResponse = restTemplate.exchange(gatewayURI, HttpMethod.POST,
					entityReq, Gateway.class);
			if (null == gatewayRegistrationResponse) {
				logger.error("Rest template Object not found");
				throw new ChirpStackClientException("Rest template Object not found");

			}

			if (HttpStatus.CONFLICT.value() == (gatewayRegistrationResponse.getStatusCodeValue())) {
				logger.error(gatewayRegistrationResponse.getHeaders().toString());
				gatewayResponse.setMessage("Name already Exist");
				gatewayResponse.setStatus(HttpStatus.CONFLICT);
				throw new GatewayAlreadyExistException(
						gatewayRegistrationResponse.getStatusCode().getReasonPhrase().toString(),
						gatewayRegistrationResponse);

			}
			if (HttpStatus.OK.value() == (gatewayRegistrationResponse.getStatusCodeValue())) {
				gatewayResponse.setMessage(request.getId());
				gatewayResponse.setStatus(HttpStatus.OK);

				logger.debug("Sucess flow and has Body? ->" + gatewayRegistrationResponse.hasBody());
				

			}

		} catch (RestClientException e) {
			throw new ChirpStackClientException(e);
		}
		return gatewayResponse;
	}
}