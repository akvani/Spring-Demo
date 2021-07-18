package com.stackroute.universityapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.universityapp.exception.CollegeIdAlreadyExistException;
import com.stackroute.universityapp.model.College;
import com.stackroute.universityapp.repository.CollegeRepo;

@Service
public class CollegeServiceImpl implements CollegeService {

	
	@Autowired
	CollegeRepo crepo;
	
	@Override
	public College addCollege(College college) throws  CollegeIdAlreadyExistException {
		
		Optional<College> optcoll=crepo.findById(college.getCollegeid());
		
		if(optcoll.isPresent())
			throw new CollegeIdAlreadyExistException();
		
		crepo.save(college);
		
		
		return college;
	}

	@Override
	public List<College> viewColleges() {
		
		return crepo.findAll();
	}

}
