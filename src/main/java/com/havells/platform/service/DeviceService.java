package com.havells.platform.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.havells.platform.exception.ChirpStackClientException;
import com.havells.platform.model.DeviceDB;
import com.havells.platform.provider.chirpstack.client.request.DeviceRegRequest;
import com.havells.platform.provider.chirpstack.client.response.Devices;

public interface DeviceService {

	List<DeviceDB> saveDevice(List<DeviceRegRequest> devices) throws ChirpStackClientException;

	CompletableFuture<Object> addDevice(List<DeviceDB> devices)
			throws ChirpStackClientException;

	//SDevices getAllDevicesByApplicationID(Integer limit, String applicationID) throws ChirpStackClientException;

	//Devices getAllDevicesByApplicationID(String limit, String applicationID) throws ChirpStackClientException;

	Devices getAllDevicesByApplicationID(String limit, String applicationID) throws ChirpStackClientException;
}