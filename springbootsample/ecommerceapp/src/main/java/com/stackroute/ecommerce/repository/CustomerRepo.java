package com.stackroute.ecommerce.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.ecommerce.model.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer,String>{
	
	List<Customer>  findByCity(String city);
	
	Customer findByCityAndCustomername(String city,String custname);

}
