package com.havells.platform.model;

import java.util.List;

public class GatewayAndDevicesStatus {
	 public DeviceStatusResponse gateway;
	 public DeviceStatusResponse devices;
	public GatewayAndDevicesStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GatewayAndDevicesStatus(DeviceStatusResponse gateway, DeviceStatusResponse devices) {
		super();
		this.gateway = gateway;
		this.devices = devices;
	}
	public DeviceStatusResponse getGateway() {
		return gateway;
	}
	public void setGateway(DeviceStatusResponse gateway) {
		this.gateway = gateway;
	}
	public DeviceStatusResponse getDevices() {
		return devices;
	}
	public void setDevices(DeviceStatusResponse devices) {
		this.devices = devices;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((devices == null) ? 0 : devices.hashCode());
		result = prime * result + ((gateway == null) ? 0 : gateway.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GatewayAndDevicesStatus other = (GatewayAndDevicesStatus) obj;
		if (devices == null) {
			if (other.devices != null)
				return false;
		} else if (!devices.equals(other.devices))
			return false;
		if (gateway == null) {
			if (other.gateway != null)
				return false;
		} else if (!gateway.equals(other.gateway))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GatewayAndDevicesStatus [gateway=" + gateway + ", devices=" + devices + "]";
	}
	
	 
}
