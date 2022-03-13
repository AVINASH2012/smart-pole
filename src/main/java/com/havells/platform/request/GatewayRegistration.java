package com.havells.platform.request;

import java.util.List;

public class GatewayRegistration {

	public List<GatewayBoard> boards;
    public String description;
    public boolean discoveryEnabled;
    public String gatewayProfileID;
    public String id;
    public Location location;
    public String name;
    public String networkServerID;
    public String organizationID;
	
    
    
    public GatewayRegistration() {
		super();
	}



	public GatewayRegistration(List<GatewayBoard> boards, String description, boolean discoveryEnabled,
			String gatewayProfileID, String id, Location location, String name, String networkServerID,
			String organizationID) {
		super();
		this.boards = boards;
		this.description = description;
		this.discoveryEnabled = discoveryEnabled;
		this.gatewayProfileID = gatewayProfileID;
		this.id = id;
		this.location = location;
		this.name = name;
		this.networkServerID = networkServerID;
		this.organizationID = organizationID;
	}



	public List<GatewayBoard> getBoards() {
		return boards;
	}



	public void setBoards(List<GatewayBoard> boards) {
		this.boards = boards;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public boolean isDiscoveryEnabled() {
		return discoveryEnabled;
	}



	public void setDiscoveryEnabled(boolean discoveryEnabled) {
		this.discoveryEnabled = discoveryEnabled;
	}



	public String getGatewayProfileID() {
		return gatewayProfileID;
	}



	public void setGatewayProfileID(String gatewayProfileID) {
		this.gatewayProfileID = gatewayProfileID;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Location getLocation() {
		return location;
	}



	public void setLocation(Location location) {
		this.location = location;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getNetworkServerID() {
		return networkServerID;
	}



	public void setNetworkServerID(String networkServerID) {
		this.networkServerID = networkServerID;
	}



	public String getOrganizationID() {
		return organizationID;
	}



	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boards == null) ? 0 : boards.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (discoveryEnabled ? 1231 : 1237);
		result = prime * result + ((gatewayProfileID == null) ? 0 : gatewayProfileID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((networkServerID == null) ? 0 : networkServerID.hashCode());
		result = prime * result + ((organizationID == null) ? 0 : organizationID.hashCode());
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
		GatewayRegistration other = (GatewayRegistration) obj;
		if (boards == null) {
			if (other.boards != null)
				return false;
		} else if (!boards.equals(other.boards))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discoveryEnabled != other.discoveryEnabled)
			return false;
		if (gatewayProfileID == null) {
			if (other.gatewayProfileID != null)
				return false;
		} else if (!gatewayProfileID.equals(other.gatewayProfileID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (networkServerID == null) {
			if (other.networkServerID != null)
				return false;
		} else if (!networkServerID.equals(other.networkServerID))
			return false;
		if (organizationID == null) {
			if (other.organizationID != null)
				return false;
		} else if (!organizationID.equals(other.organizationID))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "GatewayRegistration [boards=" + boards + ", description=" + description + ", discoveryEnabled="
				+ discoveryEnabled + ", gatewayProfileID=" + gatewayProfileID + ", id=" + id + ", location=" + location
				+ ", name=" + name + ", networkServerID=" + networkServerID + ", organizationID=" + organizationID
				+ "]";
	}
	
    
	
	
}