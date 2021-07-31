package com.stackroute.universityapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.universityapp.exception.CollegeIdAlreadyExistException;
import com.stackroute.universityapp.model.College;
import com.stackroute.universityapp.service.CollegeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/college")
public class CollegeController {
	
	@Autowired
	CollegeService cservice;
	
	@ApiOperation("Use to add new college ")

	
	@PostMapping("/addCollege")
	public ResponseEntity<?> addcollege(@RequestBody College college)
	{
		try {
			College cresult=cservice.addCollege(college);
			return new ResponseEntity<String>("Added",HttpStatus.CREATED);
			
		} catch (CollegeIdAlreadyExistException e) {
			 
			return new ResponseEntity<String>("duplicate collegeid",HttpStatus.CONFLICT);
		}
		
		
		
	}
	
	@GetMapping("/viewCollege")
	public ResponseEntity<?> viewcollege()
	{
		
		
		List<College> colleges=cservice.viewColleges();
		
		return new ResponseEntity<List>(colleges,HttpStatus.OK);
		
	}
	
}
