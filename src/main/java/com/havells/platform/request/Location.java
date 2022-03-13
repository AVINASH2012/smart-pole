package com.havells.platform.request;

public class Location {

	private long accuracy;
	private long altitude;
	private long latitude;
	private long longitude;
	private String source;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(long accuracy, long altitude, long latitude, long longitude, String source) {
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

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accuracy ^ (accuracy >>> 32));
		result = prime * result + (int) (altitude ^ (altitude >>> 32));
		result = prime * result + (int) (latitude ^ (latitude >>> 32));
		result = prime * result + (int) (longitude ^ (longitude >>> 32));
		result = prime * result + ((source == null) ? 0 : source.hashCode());
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
		Location other = (Location) obj;
		if (accuracy != other.accuracy)
			return false;
		if (altitude != other.altitude)
			return false;
		if (latitude != other.latitude)
			return false;
		if (longitude != other.longitude)
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [accuracy=" + accuracy + ", altitude=" + altitude + ", latitude=" + latitude + ", longitude="
				+ longitude + ", source=" + source + "]";
	}

}
