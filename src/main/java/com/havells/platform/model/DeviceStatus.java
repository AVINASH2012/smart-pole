package com.havells.platform.model;
import java.util.Date;

import javax.persistence.*;

import com.havells.platform.utils.AbstractTimestampEntity;


@Entity
@Table(name = "devicestatus")
public class DeviceStatus extends AbstractTimestampEntity {

	
	
	@Id 
    @Column(name = "device_id", nullable = false)
	String deviceId;
	boolean onboard;
	boolean connected;
	String current;
	private String type;
	private Date created;
	private Date updated;
	
	public DeviceStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceStatus(String deviceId, boolean onboard, boolean connected, String current,
			String type) {
		super();
		this.deviceId = deviceId;
		this.onboard = onboard;
		this.connected = connected;
		this.current = current;
		this.type = type;
	}

//----------------------------------------	
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
//------------------------------------------
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (connected ? 1231 : 1237);
		result = prime * result + ((current == null) ? 0 : current.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + (onboard ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceStatus other = (DeviceStatus) obj;
		if (connected != other.connected)
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
		return true;
	}

	@Override
	public String toString() {
		return "DeviceStatus [deviceId=" + deviceId + ", onboard=" + onboard + ", connected=" + connected + ", current="
				+ current + ", type=" + type + ", created=" + created + ", updated=" + updated + "]";
	}

	
	
}
