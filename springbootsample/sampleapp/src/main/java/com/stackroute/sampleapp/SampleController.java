package com.stackroute.sampleapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
	
	
	@GetMapping("/home")
	public ResponseEntity<?> gethome()
	{
		return  new ResponseEntity<String>("welcom sample app",HttpStatus.OK);
	}
}
