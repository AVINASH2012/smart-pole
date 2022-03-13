package com.havells.platform.request;

import java.util.List;

public class Devices {

	public Devices() {
		super();
	}

	public Devices(List<Device> devices) {
		super();
		this.devices = devices;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	private List<Device> devices;

}
