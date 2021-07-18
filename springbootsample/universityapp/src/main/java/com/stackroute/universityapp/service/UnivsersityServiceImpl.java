package com.stackroute.universityapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.universityapp.exception.UniversityAlreadyExistException;
import com.stackroute.universityapp.exception.UniversityNotFoundException;
import com.stackroute.universityapp.model.University;
import com.stackroute.universityapp.repository.UniversityRepo;

@Service
public class UnivsersityServiceImpl implements UniversityService {
	
	@Autowired
	UniversityRepo unirepo;
	
	

	@Override
	public University addUniversity(University universe) throws UniversityAlreadyExistException {
	
	Optional<University> optuniverse=unirepo.findById(universe.getUniversityid());
		
	if(optuniverse.isPresent())
		throw new UniversityAlreadyExistException("universityid is duplicate");
		
	
		unirepo.save(universe);
		
		return universe;
	}

	@Override
	public University findUniversity(String univerid)  {
	
		
		Optional<University> optuniverse=unirepo.findById(univerid);
		
		if (optuniverse.isPresent())
		
		 return optuniverse.get();
		
		else
		return null;
	}

	@Override
	public boolean deleteUniversity(String univerid) throws UniversityNotFoundException {
		
		
		Optional<University> optuniverse=unirepo.findById(univerid);
		
		if(optuniverse.isPresent())
		{
		unirepo.deleteById(univerid);
		return true;
		}
		else
		 throw new UniversityNotFoundException("invalid universityid");
	}

	@Override
	public University modifyUniversity(University modiuniverse) throws UniversityNotFoundException {
		
	University existuniverse=findUniversity(modiuniverse.getUniversityid());
		
	  if(existuniverse==null)
		  throw new UniversityNotFoundException("invalud id");
	  
	  existuniverse.setUniversityname(modiuniverse.getUniversityname());
	  
	  unirepo.save(existuniverse);
	  
	  return existuniverse;
	
	
	}

	@Override
	public List<University> getallUniversitites() {
		
		return unirepo.findAll();
	}
	
	

}
