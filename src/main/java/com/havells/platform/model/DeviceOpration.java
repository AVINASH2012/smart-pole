package com.havells.platform.model;

public class DeviceOpration {
	public boolean confirmed;
    public String data;
    public String devEUI;
    public int fCnt;
    public int fPort;
    public String jsonObject;
	public DeviceOpration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeviceOpration(boolean confirmed, String data, String devEUI, int fCnt, int fPort, String jsonObject) {
		super();
		this.confirmed = confirmed;
		this.data = data;
		this.devEUI = devEUI;
		this.fCnt = fCnt;
		this.fPort = fPort;
		this.jsonObject = jsonObject;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDevEUI() {
		return devEUI;
	}
	public void setDevEUI(String devEUI) {
		this.devEUI = devEUI;
	}
	public int getfCnt() {
		return fCnt;
	}
	public void setfCnt(int fCnt) {
		this.fCnt = fCnt;
	}
	public int getfPort() {
		return fPort;
	}
	public void setfPort(int fPort) {
		this.fPort = fPort;
	}
	public String getJsonObject() {
		return jsonObject;
	}
	public void setJsonObject(String jsonObject) {
		this.jsonObject = jsonObject;
	}
    
    
}
