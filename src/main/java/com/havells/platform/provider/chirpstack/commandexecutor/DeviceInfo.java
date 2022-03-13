package com.havells.platform.provider.chirpstack.commandexecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.havells.platform.common.MessageConstants;
import com.havells.platform.provider.chirpstack.client.request.RootDeviceQueueItem;
import com.havells.platform.provider.chirpstack.client.response.DeviceOperationResponse;

class DeviceInfo extends Executor{

	DeviceInfo(){
		super();
	}
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(DeviceInfo.class);


	void execute(String data, String devEUI) {
		RootDeviceQueueItem rootDeviceQueueItem =requestBody(data, devEUI);
		final String deviceURI = MessageConstants.API_URI + MessageConstants.DEVICES_PRIMARY;
		final String deviceOperationURL = deviceURI + "/" + devEUI + "/queue";
		HttpEntity<RootDeviceQueueItem> entityReq = new HttpEntity<RootDeviceQueueItem>(rootDeviceQueueItem, setHeader());
		try {
			System.out.println("DEVICE INFO "+deviceOperationURL +"  "+ entityReq);
			RestTemplate restTemplate = new RestTemplate();
			@SuppressWarnings("unused")
			ResponseEntity<DeviceOperationResponse> deviceOperationsResponse = restTemplate.exchange(deviceOperationURL,
					HttpMethod.POST, entityReq, DeviceOperationResponse.class);
		} catch (RestClientException e) {
			logger.error(e.getLocalizedMessage(), e);

		}
	}
	
}
