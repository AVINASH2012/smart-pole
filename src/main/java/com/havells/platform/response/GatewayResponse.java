package com.havells.platform.response;

import org.springframework.http.HttpStatus;

public class GatewayResponse {

	private String message;
	private HttpStatus status;

	public GatewayResponse(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public GatewayResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
