package com.nhs.trust.utils;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class XNuxeoAgentInterceptor implements ClientHttpRequestInterceptor {

	@Value("${user-name}")
	String userName;
	@Value("${password}")
	String password;
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body,
			ClientHttpRequestExecution execution) throws IOException {
		
		String auth = userName + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64( 
				auth.getBytes(Charset.forName("US-ASCII")) );
		String authHeader = "Basic " + new String( encodedAuth );
		HttpHeaders headers = request.getHeaders();
		headers.set("Authorization", authHeader );
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-NXDocumentProperties", "*");
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return execution.execute(request, body);
	}

	
   
    
}
