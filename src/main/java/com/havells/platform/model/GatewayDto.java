package com.havells.platform.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class GatewayDto {
		
	private String description;
	
	private boolean discoveryEnabled;
	
	private String gatewayProfileID;
	
	
	private Location Location;
	
	private String name;
	
	private String networkServerID;
	
	private String organizationID;
	
	private boolean connected=false;
	
	private String currentStatus="inactive";

	public GatewayDto(String description, boolean discoveryEnabled, String gatewayProfileID,
			com.havells.platform.model.Location location, String name, String networkServerID, String organizationID) {
		super();
		this.description = description;
		this.discoveryEnabled = discoveryEnabled;
		this.gatewayProfileID = gatewayProfileID;
		Location = location;
		this.name = name;
		this.networkServerID = networkServerID;
		this.organizationID = organizationID;
	}

	public GatewayDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public Location getLocation() {
		return Location;
	}

	public void setLocation(Location location) {
		Location = location;
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

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	
	
	

	

}
