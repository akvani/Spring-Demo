package com.stackroute.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.ecommerce.exception.CustomerNotFoundException;
import com.stackroute.ecommerce.model.Customer;
import com.stackroute.ecommerce.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("ecom/customer")
public class CustomerController {

	
	@Autowired
	CustomerService cservice;
	
	@ApiOperation("Used to add a new customer  or  new Items for existing customer")
	@PostMapping("/addCustomer")
	public ResponseEntity<?> savecustomer(@RequestBody Customer customer)
	{
Customer result=		cservice.addCustomer(customer);

return new ResponseEntity<Customer>(result,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/viewallcustomers")
	
	public ResponseEntity<?> viewallcustomer()
	{
		
		List<Customer> customers=cservice.viewCustomers();
		return new ResponseEntity<List>(customers,HttpStatus.OK);
	}
	

	@GetMapping("/viewbycity/{city}")
   public ResponseEntity<?> getcitydata(@PathVariable("city") String mycity)
   {
		
	List<Customer> customers=	cservice.findCustomerByCity(mycity);

	return new ResponseEntity<List>(customers,HttpStatus.OK);
		
   }
	
	@DeleteMapping("/deleteCustomer/{custid}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("custid") String id)
	{
		try {
			cservice.deleteCustomer(id);
			return new ResponseEntity<String>("Customer deleted",HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
	
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@DeleteMapping("/deleteItem/{custid}/{itemid}")
	
	public ResponseEntity<?> deletcustomerbyitem(@PathVariable("custid") String cid,@PathVariable("itemid") String itemid)
	
	{
		
		try {
			cservice.deleteItem(cid, itemid);
			return new ResponseEntity<String>("Item deleted",HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
	
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
}

