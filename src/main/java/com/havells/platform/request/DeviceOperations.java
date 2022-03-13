package com.havells.platform.request;

public class DeviceOperations {
	private DeviceOpration deviceQueueItem;

	public DeviceOperations() {
		super();
	}

	public DeviceOperations(DeviceOpration deviceQueueItem) {
		super();
		this.deviceQueueItem = deviceQueueItem;
	}

	public DeviceOpration getDeviceQueueItem() {
		return deviceQueueItem;
	}

	public void setDeviceQueueItem(DeviceOpration deviceQueueItem) {
		this.deviceQueueItem = deviceQueueItem;
	}

}
