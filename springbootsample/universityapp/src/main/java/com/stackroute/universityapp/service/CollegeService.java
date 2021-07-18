package com.stackroute.universityapp.service;

import java.util.List;

import com.stackroute.universityapp.exception.CollegeIdAlreadyExistException;
import com.stackroute.universityapp.model.College;

public interface CollegeService {

	College addCollege(College college) throws  CollegeIdAlreadyExistException;
	
	List<College> viewColleges();
}

