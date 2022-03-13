package com.havells.platform.request;

import com.havells.platform.model.GatewayRegistration;

public class GatewayRegRequest {
	
	private GatewayRegistration gateway;
	
	

	public GatewayRegRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GatewayRegRequest(GatewayRegistration gateway) {
		super();
		this.gateway = gateway;
	}

	public GatewayRegistration getGateway() {
		return gateway;
	}

	public void setGateway(GatewayRegistration gateway) {
		this.gateway = gateway;
	}

	@Override
	public String toString() {
		return "GatewayRegRequest [gateway=" + gateway + "]";
	}
	
	
	
}
