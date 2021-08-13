package com.stackroute.hystrix.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.stackroute.hystrix.service.AllCustomerService;

@RestController
@RequestMapping("api/ibm/ecomm")
public class AllmyController {

	@Autowired
	private AllCustomerService testservice;

	
	@GetMapping("/alldata")
	public String getNewsDetails() throws IOException, RestClientException {
		
		//System.out.println(testservice.getCustomerDetails());
		
		return testservice.getCustomerDetails();
		
	}
}
