package com.stackroute.rabbitproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(ProductService.class)

public class ProductController {

	@Autowired
	ProductService prdservice;
	
	
	@PostMapping("/addProduct")
	public ResponseEntity addproduct(@RequestBody Product product)
	{
		// code for storing the data inside database 
		
		prdservice.getProductdata().send(MessageBuilder.withPayload(product).build());
		
		return new ResponseEntity<String>("Product Added", HttpStatus.OK);
		
	}
	
	
	
}
