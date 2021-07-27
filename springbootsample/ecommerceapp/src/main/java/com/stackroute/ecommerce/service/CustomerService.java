package com.stackroute.ecommerce.service;

import java.util.List;

import com.stackroute.ecommerce.exception.CustomerNotFoundException;
import com.stackroute.ecommerce.model.Customer;

public interface CustomerService {

	Customer addCustomer(Customer cust);
	List<Customer> viewCustomers();
	List<Customer> findCustomerByCity(String cty);
	
	Customer findByCustomerid(String customerid);
	
	boolean deleteCustomer(String customerid) throws CustomerNotFoundException;
	
	boolean deleteItem(String customerid,String itemid) throws CustomerNotFoundException;
		
	
	
}
