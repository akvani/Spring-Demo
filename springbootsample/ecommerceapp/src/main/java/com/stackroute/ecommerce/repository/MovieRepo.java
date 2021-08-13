package com.stackroute.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.ecommerce.model.Movie;

@Repository
public interface MovieRepo extends MongoRepository<Movie,String> {

}
