package com.havells.platform.response;

import java.util.List;

import com.havells.platform.model.DeviceDto;
import com.havells.platform.model.GatewayDto;
import com.havells.platform.model.GatewayRegistration;

public class GatewayAndDevices {
	 public List<GatewayDto> gateway;
	 public List<DeviceDto> devices;
	public GatewayAndDevices(List<GatewayDto> gateway, List<DeviceDto> devices) {
		super();
		this.gateway = gateway;
		this.devices = devices;
	}
	public GatewayAndDevices() {
		super();
	}
	public List<GatewayDto> getGateway() {
		return gateway;
	}
	public void setGateway(List<GatewayDto> allGateway) {
		this.gateway = allGateway;
	}
	public List<DeviceDto> getDevices() {
		return devices;
	}
	public void setDevices(List<DeviceDto> devices) {
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
		GatewayAndDevices other = (GatewayAndDevices) obj;
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
		return "allGatewayAndDevices [gateway=" + gateway + ", devices=" + devices + "]";
	}
	 	 
	 
}
