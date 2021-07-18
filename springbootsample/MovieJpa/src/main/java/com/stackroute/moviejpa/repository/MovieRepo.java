package com.stackroute.moviejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.moviejpa.model.Movie;

@Repository

public interface MovieRepo  extends JpaRepository<Movie,String>{

}
