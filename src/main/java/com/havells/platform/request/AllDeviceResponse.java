package com.havells.platform.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class AllDeviceResponse {
	private String totalCount;

	private List<DeviceResponse> result;

	public AllDeviceResponse() {
	}

	public AllDeviceResponse(String totalCount, List<DeviceResponse> result) {
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
