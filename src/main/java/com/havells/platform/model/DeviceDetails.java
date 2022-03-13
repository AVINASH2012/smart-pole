package com.havells.platform.model;

public class DeviceDetails {
	private DeviceDetailsByDevEUI device;
	private String lastSeenAt;
	private long deviceStatusBattery;
	private long deviceStatusMargin;
	private Location location;
	public DeviceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeviceDetails(DeviceDetailsByDevEUI device, String lastSeenAt, long deviceStatusBattery,
			long deviceStatusMargin, Location location) {
		super();
		this.device = device;
		this.lastSeenAt = lastSeenAt;
		this.deviceStatusBattery = deviceStatusBattery;
		this.deviceStatusMargin = deviceStatusMargin;
		this.location = location;
	}
	public DeviceDetailsByDevEUI getDevice() {
		return device;
	}
	public void setDevice(DeviceDetailsByDevEUI device) {
		this.device = device;
	}
	public String getLastSeenAt() {
		return lastSeenAt;
	}
	public void setLastSeenAt(String lastSeenAt) {
		this.lastSeenAt = lastSeenAt;
	}
	public long getDeviceStatusBattery() {
		return deviceStatusBattery;
	}
	public void setDeviceStatusBattery(long deviceStatusBattery) {
		this.deviceStatusBattery = deviceStatusBattery;
	}
	public long getDeviceStatusMargin() {
		return deviceStatusMargin;
	}
	public void setDeviceStatusMargin(long deviceStatusMargin) {
		this.deviceStatusMargin = deviceStatusMargin;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "DeviceDetailsByDevEUIResponse [device=" + device + ", lastSeenAt=" + lastSeenAt
				+ ", deviceStatusBattery=" + deviceStatusBattery + ", deviceStatusMargin=" + deviceStatusMargin
				+ ", location=" + location + "]";
	}
	
	
}
