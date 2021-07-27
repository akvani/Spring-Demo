package com.stackroute.ecommerce.exception;

public class CustomerNotFoundException extends Exception{

	public CustomerNotFoundException()
	{
		super("Inavlid Customer ID");
	}
}
