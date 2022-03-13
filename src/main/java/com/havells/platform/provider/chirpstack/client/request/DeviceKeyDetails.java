package com.havells.platform.provider.chirpstack.client.request;

public class DeviceKeyDetails {
	public String appKey;
    public String devEUI;
    public String genAppKey;
    public String nwkKey;
	public DeviceKeyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeviceKeyDetails(String appKey, String devEUI, String genAppKey, String nwkKey) {
		super();
		this.appKey = appKey;
		this.devEUI = devEUI;
		this.genAppKey = genAppKey;
		this.nwkKey = nwkKey;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getDevEUI() {
		return devEUI;
	}
	public void setDevEUI(String devEUI) {
		this.devEUI = devEUI;
	}
	public String getGenAppKey() {
		return genAppKey;
	}
	public void setGenAppKey(String genAppKey) {
		this.genAppKey = genAppKey;
	}
	public String getNwkKey() {
		return nwkKey;
	}
	public void setNwkKey(String nwkKey) {
		this.nwkKey = nwkKey;
	}
	@Override
	public String toString() {
		return "DeviceKeyDetails [appKey=" + appKey + ", devEUI=" + devEUI + ", genAppKey=" + genAppKey + ", nwkKey="
				+ nwkKey + "]";
	}
    
    
}
