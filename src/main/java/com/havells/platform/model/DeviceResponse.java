package com.havells.platform.model;

public class DeviceResponse {
	private String devEUI;
	private String name;
	private String applicationID;
	private String description;
	private String deviceProfileID;
	private String deviceProfileName;
	private long deviceStatusBattery;
	private long deviceStatusMargin;
	private boolean deviceStatusExternalPowerSource;
	private boolean deviceStatusBatteryLevelUnavailable;
	private long deviceStatusBatteryLevel;
	private String lastSeenAt;
	
	public DeviceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceResponse(String devEUI, String name, String applicationID, String description, String deviceProfileID,
			String deviceProfileName, long deviceStatusBattery, long deviceStatusMargin,
			boolean deviceStatusExternalPowerSource, boolean deviceStatusBatteryLevelUnavailable,
			long deviceStatusBatteryLevel, String lastSeenAt) {
		super();
		this.devEUI = devEUI;
		this.name = name;
		this.applicationID = applicationID;
		this.description = description;
		this.deviceProfileID = deviceProfileID;
		this.deviceProfileName = deviceProfileName;
		this.deviceStatusBattery = deviceStatusBattery;
		this.deviceStatusMargin = deviceStatusMargin;
		this.deviceStatusExternalPowerSource = deviceStatusExternalPowerSource;
		this.deviceStatusBatteryLevelUnavailable = deviceStatusBatteryLevelUnavailable;
		this.deviceStatusBatteryLevel = deviceStatusBatteryLevel;
		this.lastSeenAt = lastSeenAt;
	}

	public String getDevEUI() {
		return devEUI;
	}

	public void setDevEUI(String devEUI) {
		this.devEUI = devEUI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeviceProfileID() {
		return deviceProfileID;
	}

	public void setDeviceProfileID(String deviceProfileID) {
		this.deviceProfileID = deviceProfileID;
	}

	public String getDeviceProfileName() {
		return deviceProfileName;
	}

	public void setDeviceProfileName(String deviceProfileName) {
		this.deviceProfileName = deviceProfileName;
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

	public boolean isDeviceStatusExternalPowerSource() {
		return deviceStatusExternalPowerSource;
	}

	public void setDeviceStatusExternalPowerSource(boolean deviceStatusExternalPowerSource) {
		this.deviceStatusExternalPowerSource = deviceStatusExternalPowerSource;
	}

	public boolean isDeviceStatusBatteryLevelUnavailable() {
		return deviceStatusBatteryLevelUnavailable;
	}

	public void setDeviceStatusBatteryLevelUnavailable(boolean deviceStatusBatteryLevelUnavailable) {
		this.deviceStatusBatteryLevelUnavailable = deviceStatusBatteryLevelUnavailable;
	}

	public long getDeviceStatusBatteryLevel() {
		return deviceStatusBatteryLevel;
	}

	public void setDeviceStatusBatteryLevel(long deviceStatusBatteryLevel) {
		this.deviceStatusBatteryLevel = deviceStatusBatteryLevel;
	}

	public String getLastSeenAt() {
		return lastSeenAt;
	}

	public void setLastSeenAt(String lastSeenAt) {
		this.lastSeenAt = lastSeenAt;
	}

	@Override
	public String toString() {
		return "DeviceResponse [devEUI=" + devEUI + ", name=" + name + ", applicationID=" + applicationID
				+ ", description=" + description + ", deviceProfileID=" + deviceProfileID + ", deviceProfileName="
				+ deviceProfileName + ", deviceStatusBattery=" + deviceStatusBattery + ", deviceStatusMargin="
				+ deviceStatusMargin + ", deviceStatusExternalPowerSource=" + deviceStatusExternalPowerSource
				+ ", deviceStatusBatteryLevelUnavailable=" + deviceStatusBatteryLevelUnavailable
				+ ", deviceStatusBatteryLevel=" + deviceStatusBatteryLevel + ", lastSeenAt=" + lastSeenAt + "]";
	}
	
	
	
}
