package com.havells.platform.provider.chirpstack.client.request;

public class DeviceQueueItem {

    public boolean confirmed;
    public String data;
    public String devEUI;
    public int fCnt;
    public int fPort;

    public DeviceQueueItem() {
	}
    
    

	public DeviceQueueItem(String data, String devEUI, int fCnt, int fPort) {
		super();
		this.confirmed = true;
		this.data = data;
		this.devEUI = devEUI;
		this.fCnt = fCnt;
		this.fPort = fPort;
	}

	public boolean getConfirmed() {
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (confirmed ? 1231 : 1237);
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((devEUI == null) ? 0 : devEUI.hashCode());
		result = prime * result + fCnt;
		result = prime * result + fPort;
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
		DeviceQueueItem other = (DeviceQueueItem) obj;
		if (confirmed != other.confirmed)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (devEUI == null) {
			if (other.devEUI != null)
				return false;
		} else if (!devEUI.equals(other.devEUI))
			return false;
		if (fCnt != other.fCnt)
			return false;
		if (fPort != other.fPort)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "DeviceQueueItem [confirmed=" + confirmed + ", data=" + data + ", devEUI=" + devEUI + ", fCnt=" + fCnt
				+ ", fPort=" + fPort + "]";
	}
    

}
