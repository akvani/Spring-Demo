package com.stackroute.universityapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.universityapp.model.College;


@Repository
public interface CollegeRepo  extends JpaRepository<College,String>{

}
