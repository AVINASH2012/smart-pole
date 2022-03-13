package com.havells.platform.provider.chirpstack.client.response;

import com.havells.platform.request.DeviceTags;

public class DeviceDetailsByDevEUI {
	private String applicationID;
	private String description;
	private String devEUI;
	private String deviceProfileID;
	private boolean isDisabled;
	private String name;
	private Number referenceAltitude;
	private boolean skipFCntCheck;
	private DeviceTags tags;

	public DeviceDetailsByDevEUI() {
		super();
	}

	public DeviceDetailsByDevEUI(String applicationID, String description, String devEUI, String deviceProfileID,
			boolean isDisabled, String name, Number referenceAltitude, boolean skipFCntCheck, DeviceTags tags) {
		super();
		this.applicationID = applicationID;
		this.description = description;
		this.devEUI = devEUI;
		this.deviceProfileID = deviceProfileID;
		this.isDisabled = isDisabled;
		this.name = name;
		this.referenceAltitude = referenceAltitude;
		this.skipFCntCheck = skipFCntCheck;
		this.tags = tags;
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

	public String getDevEUI() {
		return devEUI;
	}

	public void setDevEUI(String devEUI) {
		this.devEUI = devEUI;
	}

	public String getDeviceProfileID() {
		return deviceProfileID;
	}

	public void setDeviceProfileID(String deviceProfileID) {
		this.deviceProfileID = deviceProfileID;
	}

	public boolean isDisabled() {
		return isDisabled;
	}

	public void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Number getReferenceAltitude() {
		return referenceAltitude;
	}

	public void setReferenceAltitude(Number referenceAltitude) {
		this.referenceAltitude = referenceAltitude;
	}

	public boolean isSkipFCntCheck() {
		return skipFCntCheck;
	}

	public void setSkipFCntCheck(boolean skipFCntCheck) {
		this.skipFCntCheck = skipFCntCheck;
	}

	public DeviceTags getTags() {
		return tags;
	}

	public void setTags(DeviceTags tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "DeviceDetailsByDevEUI [applicationID=" + applicationID + ", description=" + description + ", devEUI="
				+ devEUI + ", deviceProfileID=" + deviceProfileID + ", isDisabled=" + isDisabled + ", name=" + name
				+ ", referenceAltitude=" + referenceAltitude + ", skipFCntCheck=" + skipFCntCheck + ", tags=" + tags
				+ "]";
	}

}
