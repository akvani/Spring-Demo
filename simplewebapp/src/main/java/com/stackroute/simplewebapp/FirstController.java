package com.stackroute.simplewebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
	
	@GetMapping("/")
	public String getHomepage()
	{
		return "index";
	}
	
	@GetMapping("/signin")
	public String getsuccesspage(@RequestParam("txtname") String name)
	{
		if(name.equals("Mary"))
			return "success";
		else
			return "fail";
		
	 
				
	}
	

}
