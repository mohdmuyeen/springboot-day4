package com.demo.spring;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestPOSTClient {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		System.out.println("-------------------");
		
		String empJsonData = "{\"empId\": 805,\"name\": \"Mubeen1\",\"city\": \"Chennai\",\"salary\": 13000}";
		System.out.println(empJsonData);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
		headers.set("Content-type", "application/json");

		HttpEntity data = new HttpEntity<>(empJsonData, headers);

		ResponseEntity resp1 = rt.exchange("http://localhost:8081/app/save", HttpMethod.POST, data, String.class);

		System.out.println(resp1.toString());
		System.out.println("-------------------");
		
	/*	String userDetails = "shantanu:welcome1";
		String encrpyptedCred = new String(Base64.encodeBase64(userDetails.getBytes()));
		System.out.println("Credianls : " + encrpyptedCred);
		
		HttpHeaders headers1 = new HttpHeaders();
		headers1.clear();
		headers1.set("Accept", "application/json");
		headers1.set("Authorization", "Basic " + encrpyptedCred);
		
		HttpEntity e = new HttpEntity<>(headers1);
		ResponseEntity resp = rt.exchange("http://localhost:8080/spring-rest-service/emp?id=1001", HttpMethod.GET, e,
				String.class);
		
		System.out.println(resp.toString());
		System.out.println("-------------------");*/
	}

}
