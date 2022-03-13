package com.havells.platform.model;

public class DeviceTags {
	private String lat;
	
	private String lng;

	public DeviceTags() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceTags(String lat, String lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "DeviceTags [lat=" + lat + ", lng=" + lng + "]";
	}
	
	
}
