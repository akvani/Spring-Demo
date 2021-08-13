package com.stackroute.ecommerce.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.ecommerce.exception.CustomerNotFoundException;
import com.stackroute.ecommerce.model.Customer;
import com.stackroute.ecommerce.model.Item;
import com.stackroute.ecommerce.model.Movie;
import com.stackroute.ecommerce.repository.CustomerRepo;
import com.stackroute.ecommerce.repository.MovieRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepo crepo;
	
	
	@Autowired
	MovieRepo mrepo;
	
	@Override
	public Customer addCustomer(Customer newcust) {
	
			Optional<Customer> optcustomer=crepo.findById(newcust.getCustomerid());
		
			
			
		if(optcustomer.isPresent())
		{
			List<Item> itemnew=newcust.getItems();
			
			Customer custexist=optcustomer.get();
			
			List<Item> itemexist=custexist.getItems();
			
		
			itemexist.addAll(itemnew);
			
			custexist.setItems(itemexist);
     
			 crepo.save(custexist);
		 		
		}
			
		else
		crepo.save(newcust);
		
		
		return newcust;
	}

	@Override
	public List<Customer> viewCustomers() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	@Override
	public List<Customer> findCustomerByCity(String cty) {
		
List<Customer> customers=crepo.findByCity(cty);
		// TODO Auto-generated method stub
		return customers;
	}

	@Override
	public Customer findByCustomerid(String customerid) {
		   
		Optional<Customer> optcustomer=crepo.findById(customerid);
		
		if(optcustomer.isPresent())
			
		return optcustomer.get();
		
		else
			return null;
	}

	@Override
	public boolean deleteCustomer(String customerid) throws CustomerNotFoundException {
	
	Optional<Customer> optcustomer=crepo.findById(customerid);
		
		if(optcustomer.isPresent())
		{
			
			crepo.deleteById(customerid);
			return true;
		}
		
		throw new CustomerNotFoundException();
		
	}

	@Override
	public boolean deleteItem(String customerid, String itemid) throws CustomerNotFoundException {
	
		Optional<Customer> optcustomer=crepo.findById(customerid);
		if(optcustomer.isPresent())
		{
			Customer custexist=optcustomer.get();
			List<Item> items=custexist.getItems();
			
			Iterator<Item> iterator=items.iterator();
			
			while(iterator.hasNext())
			{
				Item item=iterator.next();
				
				if (item.getItemid().equals(itemid))
				
					iterator.remove();
						
			}
				custexist.setItems(items);
				crepo.save(custexist);
				return true;
		}
		
			
		
		throw new CustomerNotFoundException();
		
		
	}

	@Override
	public void addMovie(Movie movie) {
		 
		mrepo.save(movie);
	}
	
	
	

}
