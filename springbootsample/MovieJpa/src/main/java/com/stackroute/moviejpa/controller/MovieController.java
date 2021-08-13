package com.stackroute.moviejpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.moviejpa.model.Movie;
import com.stackroute.moviejpa.service.MovieService;
import com.stackroute.moviejpa.service.ProductService;
 

@RestController
@EnableBinding(ProductService.class)
public class MovieController {

	
	@Autowired
	MovieService movservice;
	
	

	@Autowired
	ProductService prdservice;
	
	
	@PostMapping("/addmovie")
	public ResponseEntity<?> addmymovie(@RequestBody Movie movie)
	{
		Movie result=movservice.addMovie(movie);
		
		prdservice.getmoviedata().send(MessageBuilder.withPayload(movie).build());
		
		return new ResponseEntity<Movie>(result,HttpStatus.OK);
	}
	
	@GetMapping("/viewmovies")
	public ResponseEntity<?> getmoview()
	{
		List<Movie> movies=movservice.getmovie();
		return new ResponseEntity<List>(movies,HttpStatus.OK);
		
	}
	
}
