package com.nhs.trust.utils;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class MyErrorHandling implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
		if (clientHttpResponse.getStatusCode() != HttpStatus.OK) {
			if (clientHttpResponse.getStatusCode() == HttpStatus.FORBIDDEN) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		if (response.getStatusCode() == HttpStatus.FORBIDDEN) {
		}

	}
}  
