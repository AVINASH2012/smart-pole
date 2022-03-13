package com.havells.platform.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private long accuracy;
	private long altitude;
	private double latitude;
	private double longitude;
	private String source;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(long accuracy, long altitude, double latitude, double longitude, String source) {
		super();
		this.accuracy = accuracy;
		this.altitude = altitude;
		this.latitude = latitude;
		this.longitude = longitude;
		this.source = source;
	}

	public long getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(long accuracy) {
		this.accuracy = accuracy;
	}

	public long getAltitude() {
		return altitude;
	}

	public void setAltitude(long altitude) {
		this.altitude = altitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Location [accuracy=" + accuracy + ", altitude=" + altitude + ", latitude=" + latitude + ", longitude="
				+ longitude + ", source=" + source + "]";
	}

}
