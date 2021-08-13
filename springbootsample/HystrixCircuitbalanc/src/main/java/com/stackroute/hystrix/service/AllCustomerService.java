package com.stackroute.hystrix.service;

import java.io.IOException;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AllCustomerService {


	
	@HystrixCommand(fallbackMethod="customerfallBackSupport")
	
	public String getCustomerDetails() throws IOException, RestClientException {
		
		

		String custurl = "http://localhost:9096/ecom/customer/viewallcustomers";
		


		RestTemplate newsrestTemplate = new RestTemplate();


		String custresponse = null;
	
		try {
		
			custresponse = newsrestTemplate.exchange(custurl, HttpMethod.GET, getHeaders(), String.class).getBody();
     	} catch (Exception ce) {
			System.out.println(ce);
		}
		
		return "Cust Details :: " + custresponse ;
	}

	@SuppressWarnings("unused")
	public String customerfallBackSupport()
	{
		return "CIRCUIT breaked ENABLED , No Response from the ecomm Service "+ "Service will be back shortly" + new Date();
	}
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity(headers);
	}
}

