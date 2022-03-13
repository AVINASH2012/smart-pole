package com.havells.platform.provider.chirpstack.client;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.havells.platform.common.MessageConstants;
import com.havells.platform.controller.DeviceController;
import com.havells.platform.model.DeviceDB;
import com.havells.platform.exception.ChirpStackClientException;
import com.havells.platform.provider.chirpstack.client.request.DeviceKeys;
import com.havells.platform.provider.chirpstack.client.request.DeviceRegRequest;
import com.havells.platform.provider.chirpstack.client.request.DeviceRequest;
import com.havells.platform.provider.chirpstack.client.response.AllDeviceResponse;
import com.havells.platform.provider.chirpstack.client.response.Device;
import com.havells.platform.provider.chirpstack.client.response.DeviceOperationResponse;
import com.havells.platform.provider.chirpstack.client.response.DeviceResponse;
import com.havells.platform.provider.chirpstack.client.response.Devices;
import com.havells.platform.request.DeviceOperations;

@Service
public class ChirpStackClient {

	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(DeviceController.class);

	private HttpHeaders header = new HttpHeaders();

	final String deviceURI = MessageConstants.API_URI + MessageConstants.DEVICES_PRIMARY;

	public Devices getAllDevicesByApplicationID(String limit, String applicationID) throws ChirpStackClientException {
		logger.info(this.getClass().getName() + "Limit -> " + limit + "Application id- >" + applicationID);

		final String getAllDevicesURL = deviceURI + "?limit=" + limit + "&applicationID=" + applicationID;
		logger.info(this.getClass().getName() + "getAllDevicesURL -> " + getAllDevicesURL);

		HttpEntity<DeviceRegRequest> entityReq = new HttpEntity<DeviceRegRequest>(setHeader());
		try {
			ResponseEntity<AllDeviceResponse> deviceDetailsResponse = restTemplate.exchange(getAllDevicesURL,
					HttpMethod.GET, entityReq, AllDeviceResponse.class);
			List<DeviceResponse> response = deviceDetailsResponse.getBody().getResult();
			return findDeviceDetails(response);
		} catch (RestClientException e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			throw new ChirpStackClientException(e.getLocalizedMessage() + "Device Details Response not recived");
		}
	}

	private Devices findDeviceDetails(List<DeviceResponse> response) {
		Devices devicesResponse = new Devices();

		HttpEntity<DeviceRegRequest> entityReq = new HttpEntity<DeviceRegRequest>(setHeader());
		List<Device> devices = new ArrayList<>();
		for (DeviceResponse deviceResponse : response) {
			final String getAllDevicesURL = deviceURI + "/" + deviceResponse.getDevEUI();
			ResponseEntity<Device> deviceDetailsResponse = restTemplate.exchange(getAllDevicesURL, HttpMethod.GET,
					entityReq, Device.class);
			devices.add(deviceDetailsResponse.getBody());
		}
		devicesResponse.setDevices(devices);
		return devicesResponse;

	}

	private HttpHeaders setHeader() {
		header.add("Grpc-Metadata-Authorization", MessageConstants.APIKey);
		return header;
	}

	public HttpStatus addDeviceToChirstack(DeviceRegRequest device) {
		System.out.println(device.toString());
		HttpEntity<DeviceRegRequest> entityReq = new HttpEntity<DeviceRegRequest>(device, setHeader());

		System.out.println(entityReq.getBody());
		ResponseEntity<AllDeviceResponse> deviceDetailsResponse = restTemplate.exchange(deviceURI, HttpMethod.POST,
				entityReq, AllDeviceResponse.class);
		List<DeviceResponse> deviceResponse = deviceDetailsResponse.getBody().getResult();
		// TODO handle condition where device already added
		return deviceDetailsResponse.getStatusCode();
		// return deviceResponse;

	}

	public HttpStatus addDeviceAppKeyToChirstack(DeviceKeys deviceKey) {
		System.out.println(deviceKey.toString());
		HttpEntity<DeviceKeys> entityReq = new HttpEntity<DeviceKeys>(deviceKey, setHeader());

		System.out.println(entityReq.getBody());
		final String addDeviceKeysURL = deviceURI + "/" + deviceKey.getDeviceKeys().getDevEUI() + "/" + "keys";
		ResponseEntity<Object> deviceAppKeyResponse = restTemplate.exchange(addDeviceKeysURL, HttpMethod.POST,
				entityReq, Object.class);
		// TODO handle condition where device already added
		return deviceAppKeyResponse.getStatusCode();
	}

	public HttpStatus registerDeviceToChirpstack(DeviceRegRequest deviceRequest) {
		System.out.println("################################################################"+deviceRequest.toString());
		HttpEntity<DeviceRegRequest> entityReq = new HttpEntity<DeviceRegRequest>(deviceRequest, setHeader());

		System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEE"+entityReq.getBody());
		ResponseEntity<AllDeviceResponse> deviceDetailsResponse = restTemplate.exchange(deviceURI, HttpMethod.POST,
				entityReq, AllDeviceResponse.class);
		System.out.println(deviceDetailsResponse.toString());
		return deviceDetailsResponse.getStatusCode();
		// return deviceResponse;

	}

	public HttpStatus deviceQueue(@Valid DeviceOperations request) {
		
		final String deviceOperationURL = deviceURI + "/" + request.getDeviceQueueItem().getDevEUI() + "/queue";
		HttpEntity<DeviceOperations> entityReq = new HttpEntity<DeviceOperations>(request, setHeader());
		ResponseEntity<DeviceOperationResponse> deviceOperationsResponse = restTemplate.exchange(deviceOperationURL,
				HttpMethod.POST, entityReq, DeviceOperationResponse.class);
		System.out.println(deviceOperationsResponse.toString());
		return deviceOperationsResponse.getStatusCode();
	}
}
