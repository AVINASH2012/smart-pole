package com.havells.platform.provider.chirpstack.commandexecutor;

import org.springframework.http.HttpHeaders;

import com.havells.platform.common.MessageConstants;
import com.havells.platform.provider.chirpstack.client.request.DeviceQueueItem;
import com.havells.platform.provider.chirpstack.client.request.RootDeviceQueueItem;

public abstract class Executor {
	abstract void execute(String data, String devEUI);
	
	public HttpHeaders setHeader() {
		HttpHeaders header = new HttpHeaders();
		header.add("Grpc-Metadata-Authorization", MessageConstants.APIKey);
		return header;
	}
	public RootDeviceQueueItem requestBody(String data, String devEui) {
		DeviceQueueItem deviceQueueItem = new DeviceQueueItem ();
		deviceQueueItem.setDevEUI(devEui);
		deviceQueueItem.setConfirmed(true);
		deviceQueueItem.setData(data);
		deviceQueueItem.setfCnt(0);
		deviceQueueItem.setfPort(9);
		RootDeviceQueueItem rootDeviceQueueItem= new RootDeviceQueueItem();
		rootDeviceQueueItem.setDeviceQueueItem(deviceQueueItem);
		return rootDeviceQueueItem;
	}
}
