package com.havells.platform.response;

import java.util.List;

import com.havells.platform.provider.chirpstack.client.response.Device;

public class DevicesResponse {
	private List<DeviceResponse> deviceResponse;

	public DevicesResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DevicesResponse(List<DeviceResponse> deviceResponse) {
		super();
		this.deviceResponse = deviceResponse;
	}

	public List<DeviceResponse> getDeviceResponse() {
		return deviceResponse;
	}

	public void setDeviceResponse(List<DeviceResponse> deviceResponse) {
		this.deviceResponse = deviceResponse;
	}
	
	

}
