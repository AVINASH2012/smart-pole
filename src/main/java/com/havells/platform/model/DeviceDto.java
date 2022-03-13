package com.havells.platform.model;

import java.beans.JavaBean;

import javax.persistence.Basic;
import com.havells.platform.common.Status;

@JavaBean
public class DeviceDto{
	
	private String applicationID;

	private String description;

	private String devEUI;

	private String deviceProfileID;

	private boolean isDisabled;

	private String name;

	private Number referenceAltitude;

	private boolean skipFCntCheck;

	private String latitude;

	private String longitude;
	
	private Status appKeyStatus = Status.PENDING;

	private Status onboardStatus = Status.PENDING;
	
	private boolean connected=false;
	
	private String currentStatus="inactive";
	
	private boolean on;

	public  DeviceDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceDto(long id, String applicationID, String description, String devEUI, String deviceProfileID,
			boolean isDisabled, String name, Number referenceAltitude, boolean skipFCntCheck, String latitude,
			String longitude, Status appKeyStatus, Status onboardStatus) {
		super();
		this.applicationID = applicationID;
		this.description = description;
		this.devEUI = devEUI;
		this.deviceProfileID = deviceProfileID;
		this.isDisabled = isDisabled;
		this.name = name;
		this.referenceAltitude = referenceAltitude;
		this.skipFCntCheck = skipFCntCheck;
		this.latitude = latitude;
		this.longitude = longitude;
		this.appKeyStatus = appKeyStatus;
		this.onboardStatus = onboardStatus;
	}
	
	

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Status getAppKeyStatus() {
		return appKeyStatus;
	}

	public void setAppKeyStatus(Status appKeyStatus) {
		this.appKeyStatus = appKeyStatus;
	}

	public Status getOnboardStatus() {
		return onboardStatus;
	}

	public void setOnboardStatus(Status onboardStatus) {
		this.onboardStatus = onboardStatus;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appKeyStatus == null) ? 0 : appKeyStatus.hashCode());
		result = prime * result + ((applicationID == null) ? 0 : applicationID.hashCode());
		result = prime * result + (connected ? 1231 : 1237);
		result = prime * result + ((currentStatus == null) ? 0 : currentStatus.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((devEUI == null) ? 0 : devEUI.hashCode());
		result = prime * result + ((deviceProfileID == null) ? 0 : deviceProfileID.hashCode());
		result = prime * result + (isDisabled ? 1231 : 1237);
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((onboardStatus == null) ? 0 : onboardStatus.hashCode());
		result = prime * result + ((referenceAltitude == null) ? 0 : referenceAltitude.hashCode());
		result = prime * result + (skipFCntCheck ? 1231 : 1237);
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
		DeviceDto other = (DeviceDto) obj;
		if (appKeyStatus != other.appKeyStatus)
			return false;
		if (applicationID == null) {
			if (other.applicationID != null)
				return false;
		} else if (!applicationID.equals(other.applicationID))
			return false;
		if (connected != other.connected)
			return false;
		if (currentStatus == null) {
			if (other.currentStatus != null)
				return false;
		} else if (!currentStatus.equals(other.currentStatus))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (devEUI == null) {
			if (other.devEUI != null)
				return false;
		} else if (!devEUI.equals(other.devEUI))
			return false;
		if (deviceProfileID == null) {
			if (other.deviceProfileID != null)
				return false;
		} else if (!deviceProfileID.equals(other.deviceProfileID))
			return false;
		if (isDisabled != other.isDisabled)
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (onboardStatus != other.onboardStatus)
			return false;
		if (referenceAltitude == null) {
			if (other.referenceAltitude != null)
				return false;
		} else if (!referenceAltitude.equals(other.referenceAltitude))
			return false;
		if (skipFCntCheck != other.skipFCntCheck)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AllDevices [applicationID=" + applicationID + ", description=" + description
				+ ", devEUI=" + devEUI + ", deviceProfileID=" + deviceProfileID + ", isDisabled=" + isDisabled
				+ ", name=" + name + ", referenceAltitude=" + referenceAltitude + ", skipFCntCheck=" + skipFCntCheck
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", appKeyStatus=" + appKeyStatus
				+ ", onboardStatus=" + onboardStatus + ", connected=" + connected + ", currentStatus=" + currentStatus
				+ "]";
	} 
	
	

}
