package com.stackroute.fridaysample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
	
	
	@GetMapping("/home")
	
	public ResponseEntity<?> gethome()
	{
		return  new ResponseEntity<String>("welcome",HttpStatus.OK);
	}

}
