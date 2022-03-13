package com.havells.platform.model;

public class DeviceStatusResponse {
	public int connected;
    public int active;
    public int inactive;
    public int shutdown;
    public int maintainance;
    public String type;
	public DeviceStatusResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeviceStatusResponse(int connected, int active, int inactive, int shutdown, int maintainance, String type) {
		super();
		this.connected = connected;
		this.active = active;
		this.inactive = inactive;
		this.shutdown = shutdown;
		this.maintainance = maintainance;
		this.type=type;
	}
	public int getConnected() {
		return connected;
	}
	public void setConnected(int connected) {
		this.connected = connected;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getInactive() {
		return inactive;
	}
	public void setInactive(int inactive) {
		this.inactive = inactive;
	}
	public int getShutdown() {
		return shutdown;
	}
	public void setShutdown(int shutdown) {
		this.shutdown = shutdown;
	}
	public int getMaintainance() {
		return maintainance;
	}
	public void setMaintainance(int maintainance) {
		this.maintainance = maintainance;
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
		int result = 1;
		result = prime * result + active;
		result = prime * result + connected;
		result = prime * result + inactive;
		result = prime * result + maintainance;
		result = prime * result + shutdown;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		DeviceStatusResponse other = (DeviceStatusResponse) obj;
		if (active != other.active)
			return false;
		if (connected != other.connected)
			return false;
		if (inactive != other.inactive)
			return false;
		if (maintainance != other.maintainance)
			return false;
		if (shutdown != other.shutdown)
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
		return "DeviceStatusResponse [connected=" + connected + ", active=" + active + ", inactive=" + inactive
				+ ", shutdown=" + shutdown + ", maintainance=" + maintainance + ", type=" + type + "]";
	}
	
    
}
