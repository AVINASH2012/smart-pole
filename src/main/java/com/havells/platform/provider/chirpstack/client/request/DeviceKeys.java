package com.havells.platform.provider.chirpstack.client.request;

public class DeviceKeys {
	public DeviceKeyDetails deviceKeys;

	public DeviceKeys() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceKeys(DeviceKeyDetails deviceKeys) {
		super();
		this.deviceKeys = deviceKeys;
	}

	public DeviceKeyDetails getDeviceKeys() {
		return deviceKeys;
	}

	public void setDeviceKeys(DeviceKeyDetails deviceKeys) {
		this.deviceKeys = deviceKeys;
	}

	@Override
	public String toString() {
		return "DeviceKeys [deviceKeys=" + deviceKeys + "]";
	}
	
	
	
}
