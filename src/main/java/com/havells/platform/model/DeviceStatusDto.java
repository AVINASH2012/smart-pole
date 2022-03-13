package com.havells.platform.model;

import java.util.Date;

import javax.persistence.Id;

import com.havells.platform.utils.AbstractTimestampEntity;

public class DeviceStatusDto {
	
	@Id 
	private String deviceId;
	private boolean onboard;
	boolean connected;
	private String current;
	private String type;
	private Date created;
	private Date updated;
	public DeviceStatusDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceStatusDto(String deviceId, boolean onboard, boolean connected, String current, String type,
			Date created, Date updated) {
		super();
		this.deviceId = deviceId;
		this.onboard = onboard;
		this.connected = connected;
		this.current = current;
		this.type = type;
		this.created = created;
		this.updated = updated;
	}
	
	

	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public boolean isOnboard() {
		return onboard;
	}
	public void setOnboard(boolean onboard) {
		this.onboard = onboard;
	}
	public boolean isConnected() {
		return connected;
	}
	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (connected ? 1231 : 1237);
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((current == null) ? 0 : current.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + (onboard ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
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
		DeviceStatusDto other = (DeviceStatusDto) obj;
		if (connected != other.connected)
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (current == null) {
			if (other.current != null)
				return false;
		} else if (!current.equals(other.current))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (onboard != other.onboard)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DeviceStatusDto [deviceId=" + deviceId + ", onboard=" + onboard + ", connected=" + connected
				+ ", current=" + current + ", type=" + type + ", created=" + created + ", updated=" + updated + "]";
	}
	
	
	
	
}
