package com.havells.platform.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.havells.platform.common.MessageConstants;
import com.havells.platform.common.Status;
import com.havells.platform.controller.DeviceController;
import com.havells.platform.exception.ChirpStackClientException;
import com.havells.platform.exception.DeviceAppKeyRegistrationFailed;
import com.havells.platform.model.ApplicationKeyModel;
import com.havells.platform.model.DeviceDB;
import com.havells.platform.provider.chirpstack.client.ChirpStackClient;
import com.havells.platform.provider.chirpstack.client.request.DeviceKeyDetails;
import com.havells.platform.provider.chirpstack.client.request.DeviceKeys;
import com.havells.platform.provider.chirpstack.client.request.DeviceRegRequest;
import com.havells.platform.provider.chirpstack.client.request.DeviceRequest;
import com.havells.platform.provider.chirpstack.client.response.DeviceOperationResponse;
import com.havells.platform.provider.chirpstack.client.response.Devices;
import com.havells.platform.repositories.ApplicationKeyRepository;
import com.havells.platform.repositories.DeviceRepository;
import com.havells.platform.request.Device;
import com.havells.platform.request.DeviceOperations;
import com.havells.platform.request.DeviceTags;
import com.havells.platform.response.DeviceResponse;
import com.havells.platform.response.DevicesResponse;

@Transactional
@Service
public class DeviceServiceImpl implements DeviceService {

	final String uri = MessageConstants.API_URI + MessageConstants.DEVICES_PRIMARY;

	@Autowired
	private DeviceRepository deviceRepository;
	private Logger logger = LoggerFactory.getLogger(DeviceController.class);
	@Autowired
	private ChirpStackClient chirpstackClient;
	@Autowired
	private ApplicationKeyRepository applicationKeyRepository;
	@Autowired
	private DeviceStatusService deviceStatusService;

	public DeviceServiceImpl() {

	}

	public DeviceServiceImpl(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	@Override
	public List<DeviceDB> saveDevice(List<DeviceRegRequest> devices) throws ChirpStackClientException {
		logger.debug(this.deviceRepository.getClass() + " Enterting save method ");
		List<DeviceDB> deviceDBs = new ArrayList<DeviceDB>();

		for (DeviceRegRequest device : devices) {
			DeviceDB devicedb = new DeviceDB();
			devicedb.setApplicationID(device.getDevice().getApplicationID());
			devicedb.setDescription(device.getDevice().getDescription());
			devicedb.setDevEUI(device.getDevice().getDevEUI());
			devicedb.setDeviceProfileID(device.getDevice().getDeviceProfileID());
			devicedb.setDisabled(device.getDevice().isDisabled());
			devicedb.setName(device.getDevice().getName());
			devicedb.setReferenceAltitude(device.getDevice().getReferenceAltitude());
			devicedb.setSkipFCntCheck(device.getDevice().isSkipFCntCheck());
			deviceDBs.add(devicedb);
		} // end of for

		return deviceRepository.saveAll(deviceDBs);

	}

	@Override
	public CompletableFuture<Object> addDevice(List<DeviceDB> devices) throws ChirpStackClientException {

		logger.debug(this.deviceRepository.getClass() + " Enterting save method ");
		for (DeviceDB device : devices) {
			addDeviceHandler(device);
		} // end of for
		return null;
		// dbResponse = deviceRepository.saveAll(deviceDBs);
		// chirpstackClient.addDevice(deviceDBs);
		// return CompletableFuture.completedFuture(dbResponse);
	}
	
	public List<DeviceDB> addDeviceToDB(List<DeviceDB> devices) {
		return deviceRepository.saveAll(devices);
	}
	
	// @Async
	public String addDeviceHandler(DeviceDB devicedb) {
		// DeviceDB devicedb = new DeviceDB();
		deviceRepository.save(devicedb);
		Optional<DeviceDB> device = deviceRepository.findById(devicedb.getId());
		if (device.isPresent()) {
			DeviceRequest registerDeviceBody = new DeviceRequest();
			registerDeviceBody = deviceRegistrationBody(devicedb, registerDeviceBody);
			DeviceRegRequest deviceRegRequest = new DeviceRegRequest();
			deviceRegRequest.setDevice(registerDeviceBody);
			deviceStatusService.createRecord(devicedb.getDevEUI(),"light");
			HttpStatus chirpstackAddStatus = chirpstackClient.addDeviceToChirstack(deviceRegRequest);
			System.out.println("CREATED" + chirpstackAddStatus);
			if (chirpstackAddStatus == HttpStatus.OK) {
				devicedb.setOnboardStatus(Status.COMPLETED);
				HttpStatus deviceKeyStatus = addDeviceKey(devicedb.getDevEUI());
				if (deviceKeyStatus.equals(HttpStatus.OK)) {
					devicedb.setAppKeyStatus(Status.COMPLETED);
					deviceRepository.save(devicedb);
					deviceStatusService.createRecord(devicedb.getDevEUI(),"light");
				} else {
					return "Registering device app key failed";
				}

			} else {
				// TODO make device status failed

				return "Update Failed";
			}
			return "Update Successfull";
		} else {
			return "Update Failed";
		}
	}

	private DeviceRequest deviceRegistrationBody(DeviceDB devicedb, DeviceRequest registerDeviceBody) {

		registerDeviceBody.setApplicationID(devicedb.getApplicationID());
		registerDeviceBody.setDescription(devicedb.getDescription());
		registerDeviceBody.setDevEUI(devicedb.getDevEUI());
		registerDeviceBody.setDeviceProfileID(devicedb.getDeviceProfileID());
		registerDeviceBody.setDisabled(devicedb.isDisabled());
		registerDeviceBody.setName(devicedb.getName());
		registerDeviceBody.setReferenceAltitude(devicedb.getReferenceAltitude());
		registerDeviceBody.setSkipFCntCheck(devicedb.isSkipFCntCheck());
		return registerDeviceBody;
	}

	public HttpStatus addDeviceKey(String deviceEUI) {
		System.out.println(" HELLO DEVICE ADD KEY IS " + deviceEUI);
		DeviceKeys deviceKeyBody = deviceKeyBody(deviceEUI);
		HttpStatus chirpstackAddStatus = chirpstackClient.addDeviceAppKeyToChirstack(deviceKeyBody);
		return chirpstackAddStatus;
	}

	private DeviceKeys deviceKeyBody(String deviceEUI) {
		String deviceKey = getDeviceKeyFromDB(deviceEUI);
		DeviceKeys deviceKeys = new DeviceKeys();
		DeviceKeyDetails details = new DeviceKeyDetails();
		details.setDevEUI(deviceEUI);
		details.setNwkKey(deviceKey);
		deviceKeys.setDeviceKeys(details);
		return deviceKeys;
	}

	private String getDeviceKeyFromDB(String deviceEUI) {
		ApplicationKeyModel appkey = applicationKeyRepository.findByDeviceId(deviceEUI);
		System.out.println("APPLI KEY IS " + appkey);
		return appkey.getApplicationKey();
	}

//	public static Flux<Object> send(DeviceRegRequest device) {
//		// Simulate the data streaming every 2 seconds.
//		return Flux.from(device);
//	}

	@Override
	public Devices getAllDevicesByApplicationID(String limit, String applicationID) throws ChirpStackClientException {
		logger.info(this.getClass().getName() + "Limit -> " + limit + "Application id- >" + applicationID);

		return chirpstackClient.getAllDevicesByApplicationID(limit, applicationID);
	}

	public DevicesResponse addDevices(com.havells.platform.request.@Valid Devices request) throws DeviceAppKeyRegistrationFailed, ChirpStackClientException {
		DeviceResponse res = new DeviceResponse();
		DevicesResponse devicesResponse =  new  DevicesResponse();
		List<DeviceResponse> deviceResponse = new ArrayList<DeviceResponse>();
		List<DeviceDB> devices = prepareDBObject(request);
		for (DeviceDB deviceDB : devices) {
			logger.debug(deviceDB.toString());
			System.out.println(deviceDB.toString());
			 res = registerDeviceToChirpStack(deviceDB);
			 //deviceResponse.add(res);
		}
		devicesResponse.setDeviceResponse(deviceResponse);
		return devicesResponse;

	}

	private DeviceResponse registerDeviceToChirpStack(DeviceDB deviceDB) throws DeviceAppKeyRegistrationFailed, ChirpStackClientException {
		DeviceRequest registerDeviceBody = new DeviceRequest();
		registerDeviceBody = buildDeviceRequestForChirpStack(deviceDB, registerDeviceBody);
		DeviceRegRequest deviceRegRequest = new DeviceRegRequest();
		deviceRegRequest.setDevice(registerDeviceBody);
//		deviceRequest = buildDeviceRequestForChirpStack(deviceDB, deviceRequest);

		HttpStatus chirpstackAddStatus = chirpstackClient.registerDeviceToChirpstack(deviceRegRequest);
		System.out.println("CREATED" + chirpstackAddStatus);
		if (chirpstackAddStatus == HttpStatus.OK) {
			deviceDB.setOnboardStatus(Status.COMPLETED);
			HttpStatus deviceKeyStatus = addDeviceKey(deviceDB.getDevEUI());
			if (deviceKeyStatus.equals(HttpStatus.OK)) {
				deviceDB.setAppKeyStatus(Status.COMPLETED);
				DeviceDB device = deviceRepository.save(deviceDB);
				System.out.println("---------------------------------------");
				System.out.println(device);
				System.out.println("---------------------------------------");
				
			} else {
				throw new DeviceAppKeyRegistrationFailed("Appkey");
				

			}

		}else {
			throw new ChirpStackClientException();
		}
		return null;

	}

	private DeviceRequest buildDeviceRequestForChirpStack(DeviceDB deviceDB, DeviceRequest registerDeviceBody) {

		registerDeviceBody.setApplicationID(deviceDB.getApplicationID());
		registerDeviceBody.setDescription(deviceDB.getDescription());
		registerDeviceBody.setDevEUI(deviceDB.getDevEUI());
		registerDeviceBody.setDeviceProfileID(deviceDB.getDeviceProfileID());
		registerDeviceBody.setDisabled(deviceDB.isDisabled());
		registerDeviceBody.setName(deviceDB.getName());
		registerDeviceBody.setReferenceAltitude(deviceDB.getReferenceAltitude());
		registerDeviceBody.setSkipFCntCheck(deviceDB.isSkipFCntCheck());
		DeviceTags tags = new DeviceTags();
		tags.setLat(deviceDB.getLatitude());
		tags.setLng(deviceDB.getLongitude());
		registerDeviceBody.setTags(tags);
		return registerDeviceBody;
	}

	/**
	 * @param request
	 * @return
	 */
	public List<DeviceDB> prepareDBObject(com.havells.platform.request.@Valid Devices request) {
		List<DeviceDB> deviceDBs = new ArrayList<DeviceDB>();

		for (Device device : request.getDevices()) {
			DeviceDB devicedb = new DeviceDB();
			devicedb.setApplicationID(device.getApplicationID());
			devicedb.setDescription(device.getDescription());
			devicedb.setDevEUI(device.getDevEUI());
			devicedb.setDeviceProfileID(device.getDeviceProfileID());
			devicedb.setDisabled(device.isDisabled());
			devicedb.setName(device.getName());
			devicedb.setReferenceAltitude(device.getReferenceAltitude());
			devicedb.setSkipFCntCheck(device.isSkipFCntCheck());
			devicedb.setLatitude(device.getLatitude());
			devicedb.setLongitude(device.getLongitude());
			deviceDBs.add(devicedb);
		}
		return deviceRepository.saveAll(deviceDBs);

	}

	public HttpStatus deviceOprations(@Valid DeviceOperations request) {
		
		return chirpstackClient.deviceQueue(request);
	}

	public void deleteAllDevice() {
		deviceRepository.deleteAll();
		// TODO Auto-generated method stub
	}

}
