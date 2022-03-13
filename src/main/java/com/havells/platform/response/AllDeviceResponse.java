package com.havells.platform.response;

import java.util.List;

public class AllDeviceResponse {
	private String totalCount;
	
	private List<DeviceResponse> result;

	public AllDeviceResponse() {
		super();
	}

	public AllDeviceResponse(String totalCount, List<DeviceResponse> result) {
		super();
		this.totalCount = totalCount;
		this.result = result;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public List<DeviceResponse> getResult() {
		return result;
	}

	public void setResult(List<DeviceResponse> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "AllDeviceResponse [totalCount=" + totalCount + ", result=" + result + "]";
	}
	
	
}
