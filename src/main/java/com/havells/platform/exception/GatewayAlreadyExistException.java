package com.havells.platform.exception;

import org.springframework.http.ResponseEntity;

import com.havells.platform.provider.chirpstack.client.response.Gateway;

public class GatewayAlreadyExistException extends ChirpStackClientException {

	public GatewayAlreadyExistException(String string, ResponseEntity<Gateway> gatewayRegistrationResponse) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
