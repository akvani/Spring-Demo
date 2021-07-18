package com.stackroute.restsample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.restsample.model.Movie;

@RestController
public class Myrestcontroller {
	
	
	@GetMapping("/home")
	
	public ResponseEntity<?> getHome()
	{
	  return new ResponseEntity<String>("Rest World",HttpStatus.OK);	
		
	}

	@PostMapping ("/addmovie")
	public ResponseEntity<?> storedata(@RequestBody Movie movie)
	{

		 System.out.println(movie.getMoviename());
		//code for storing movie
		return new ResponseEntity<String>("Movie stored",HttpStatus.CREATED);
	}
	
	
}
