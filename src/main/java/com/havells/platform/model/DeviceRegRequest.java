package com.havells.platform.model;

public class DeviceRegRequest {
	private DeviceRegistration device;


	public DeviceRegRequest(DeviceRegistration device) {
		super();
		this.device = device;
	}

	public DeviceRegistration getDevice() {
		return device;
	}

	public void setDevice(DeviceRegistration device) {
		this.device = device;
	}

	@Override
	public String toString() {
		return "DeviceRegRequest [device=" + device + "]";
	}
	
	
}
