package com.havells.platform.exception;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class HttpResponseErrorHandler implements ResponseErrorHandler {
	
	private final Logger LOG = LoggerFactory.getLogger(HttpResponseErrorHandler.class);

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub
		return response.getStatusCode().is4xxClientError();
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub
		LOG.error("Platform Error Handler | HTTP Status Code: " + response.getStatusCode().value());
	}

}
