package com.demo.spring;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient1 {

	public static void main(String[] args) {
		String userDetails = "shantanu:welcome1";
		String encrpyptedCred = new String(Base64.encodeBase64(userDetails.getBytes()));
		System.out.println("Credianls : " + encrpyptedCred);
		RestTemplate rt = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", "Basic " + encrpyptedCred);
		
		HttpEntity e = new HttpEntity<>(headers);
		ResponseEntity resp = rt.exchange("http://localhost:8080/spring-rest-service/emp?id=1001", HttpMethod.GET, e,
				String.class);
		
		System.out.println(resp.toString());

	}

}
