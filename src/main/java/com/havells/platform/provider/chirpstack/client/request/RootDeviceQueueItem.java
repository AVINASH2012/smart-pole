package com.havells.platform.provider.chirpstack.client.request;

public class RootDeviceQueueItem {

	public DeviceQueueItem deviceQueueItem;
	
	public RootDeviceQueueItem() {
	}
	
    
	public RootDeviceQueueItem(DeviceQueueItem deviceQueueItem) {
		super();
		this.deviceQueueItem = deviceQueueItem;
	}



	public DeviceQueueItem getDeviceQueueItem() {
		return deviceQueueItem;
	}

	public void setDeviceQueueItem(DeviceQueueItem deviceQueueItem) {
		this.deviceQueueItem = deviceQueueItem;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deviceQueueItem == null) ? 0 : deviceQueueItem.hashCode());
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
		RootDeviceQueueItem other = (RootDeviceQueueItem) obj;
		if (deviceQueueItem == null) {
			if (other.deviceQueueItem != null)
				return false;
		} else if (!deviceQueueItem.equals(other.deviceQueueItem))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "RootDeviceQueueItem [deviceQueueItem=" + deviceQueueItem + "]";
	}
    
}
