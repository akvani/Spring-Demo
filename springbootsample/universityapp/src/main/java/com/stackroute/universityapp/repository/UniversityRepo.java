package com.stackroute.universityapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.universityapp.model.University;

@Repository
public interface UniversityRepo extends JpaRepository<University,String>{
	
  University findByUniversityname(String uname);
  
}
