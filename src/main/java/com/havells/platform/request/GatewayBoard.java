package com.havells.platform.request;

public class GatewayBoard {
	 public String fineTimestampKey;
	 public String fpgaID;
	 
	
	 
	public GatewayBoard() {
		super();
	}



	public GatewayBoard(String fineTimestampKey, String fpgaID) {
		super();
		this.fineTimestampKey = fineTimestampKey;
		this.fpgaID = fpgaID;
	}



	public String getFineTimestampKey() {
		return fineTimestampKey;
	}



	public void setFineTimestampKey(String fineTimestampKey) {
		this.fineTimestampKey = fineTimestampKey;
	}



	public String getFpgaID() {
		return fpgaID;
	}



	public void setFpgaID(String fpgaID) {
		this.fpgaID = fpgaID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fineTimestampKey == null) ? 0 : fineTimestampKey.hashCode());
		result = prime * result + ((fpgaID == null) ? 0 : fpgaID.hashCode());
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
		GatewayBoard other = (GatewayBoard) obj;
		if (fineTimestampKey == null) {
			if (other.fineTimestampKey != null)
				return false;
		} else if (!fineTimestampKey.equals(other.fineTimestampKey))
			return false;
		if (fpgaID == null) {
			if (other.fpgaID != null)
				return false;
		} else if (!fpgaID.equals(other.fpgaID))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "GatewayBoard [fineTimestampKey=" + fineTimestampKey + ", fpgaID=" + fpgaID + "]";
	}
	
	
	 
}
