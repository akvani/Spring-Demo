package com.stackroute.moviejpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.moviejpa.model.Movie;
import com.stackroute.moviejpa.service.MovieService;

@RestController
public class MovieController {

	
	@Autowired
	MovieService movservice;
	
	
	@PostMapping("/addmovie")
	public ResponseEntity<?> addmymovie(@RequestBody Movie movie)
	{
		Movie result=movservice.addMovie(movie);
		
		return new ResponseEntity<Movie>(result,HttpStatus.OK);
	}
	
	
}
