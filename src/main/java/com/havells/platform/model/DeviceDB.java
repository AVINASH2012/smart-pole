package com.havells.platform.model;

import com.havells.platform.common.Status;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEVICES")
public class DeviceDB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	// TODO Make composite keys
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
	
	
	

	public DeviceDB() {
		super();
	}

	

	public DeviceDB(long id, String applicationID, String description, String devEUI, String deviceProfileID,
			boolean isDisabled, String name, Number referenceAltitude, boolean skipFCntCheck, String latitude,
			String longitude, Status appKeyStatus, Status onboardStatus) {
		super();
		this.id = id;
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

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
