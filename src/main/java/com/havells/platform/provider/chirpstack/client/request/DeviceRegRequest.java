package com.havells.platform.provider.chirpstack.client.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.havells.platform.model.DeviceDB;

public class DeviceRegRequest {
	private DeviceRequest device;

	public DeviceRegRequest() {
		
	}
	
	public DeviceRegRequest(DeviceRequest device) {
		super();
		this.device = device;
	}

	public DeviceRequest getDevice() {
		return device;
	}

	public void setDevice(DeviceRequest device) {
		this.device = device;
	}

	@Override
	public String toString() {
		return "DeviceRegRequest [device=" + device + "]";
	}


}
