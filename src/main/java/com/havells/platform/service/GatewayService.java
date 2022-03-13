package com.havells.platform.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.havells.platform.exception.ChirpStackClientException;
import com.havells.platform.model.GatewayRegistration;
import com.havells.platform.provider.chirpstack.client.GatewayClient;
import com.havells.platform.repositories.GatewayRepository;
import com.havells.platform.response.GatewayResponse;

@Service
@Transactional
public class GatewayService {
	@Autowired
	private GatewayRepository gatewayRepository;
	@Autowired
	private DeviceStatusService deviceStatusService;

	@Autowired
	public RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private GatewayClient gatewayClient;
	GatewayResponse gatewayResponse;

	public GatewayResponse registerGateway(@Valid GatewayRegistration request) {
		logger.debug(request.toString());

		try {
			gatewayResponse = gatewayClient.gatewayRegistration(request);
			deviceStatusService.createRecord(request.getId(),"gateway");
			
		} catch (ChirpStackClientException e) {
			logger.error(gatewayResponse.getMessage());
		}

		if (HttpStatus.OK == (gatewayResponse.getStatus())) {
			gatewayRepository.save(request);

		}
		return gatewayResponse;
	}

	public void deleteAllKeys() {
		gatewayRepository.deleteAll();
		// TODO Auto-generated method stub
		
	}

}
