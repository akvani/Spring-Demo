package com.stackroute.universityapp.exception;

public class CollegeIdAlreadyExistException extends Exception {
	
	public CollegeIdAlreadyExistException()
	{
		super("duplicate college id");
	}

}
