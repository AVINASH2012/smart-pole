package com.havells.platform.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class GatewayRegistration {
	@Id
	private String id;
	
	private String description;
	
	private boolean discoveryEnabled;
	
	private String gatewayProfileID;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Location Location;
	
	private String name;
	
	private String networkServerID;
	
	private String organizationID;

	public GatewayRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GatewayRegistration(String id, String description, boolean discoveryEnabled, String gatewayProfileID,
			com.havells.platform.model.Location Location, String name, String networkServerID, String organizationID) {
		super();
		this.id = id;
		this.description = description;
		this.discoveryEnabled = discoveryEnabled;
		this.gatewayProfileID = gatewayProfileID;
		this.Location = Location;
		this.name = name;
		this.networkServerID = networkServerID;
		this.organizationID = organizationID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setLocation(Location Location) {
		this.Location = Location;
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
	public String toString() {
		return "GatewayRegistration [id=" + id + ", description=" + description + ", discoveryEnabled=" + discoveryEnabled
				+ ", gatewayProfileID=" + gatewayProfileID + ", Location=" + Location + ", name=" + name
				+ ", networkServerID=" + networkServerID + ", organizationID=" + organizationID + "]";
	}
	
	
	
}