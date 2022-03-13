package com.havells.platform.provider.chirpstack.client.response;

public class DeviceOperationResponse {
	private long fCnt;

	
	public DeviceOperationResponse() {
		super();
	}


	public DeviceOperationResponse(int fCnt) {
		super();
		this.fCnt = fCnt;
	}


	public long getfCnt() {
		return fCnt;
	}


	public void setfCnt(long fCnt) {
		this.fCnt = fCnt;
	}
	
	
	
	
}
