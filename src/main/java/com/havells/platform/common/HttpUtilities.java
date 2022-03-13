package com.havells.platform.common;

import org.springframework.http.*;

public class HttpUtilities {
	
	public HttpHeaders setHeader() {
		HttpHeaders header = new HttpHeaders();
		header.add("Grpc-Metadata-Authorization", MessageConstants.APIKey);
		return header;
	}
}
