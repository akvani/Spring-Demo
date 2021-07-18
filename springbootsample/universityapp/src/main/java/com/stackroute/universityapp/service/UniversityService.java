package com.stackroute.universityapp.service;

import java.util.List;

import com.stackroute.universityapp.exception.UniversityAlreadyExistException;
import com.stackroute.universityapp.exception.UniversityNotFoundException;
import com.stackroute.universityapp.model.University;

public interface UniversityService {
	
University	addUniversity(University universe) throws UniversityAlreadyExistException;

University findUniversity(String univerid) ;

boolean deleteUniversity(String univerid) throws UniversityNotFoundException;

University modifyUniversity(University universe) throws UniversityNotFoundException;

List<University> getallUniversitites();


}
