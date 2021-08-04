package com.stackroute.authorizeapp.service;

import com.stackroute.authorizeapp.model.UserProfile;

public interface UserprofileService {

	UserProfile addUser(UserProfile usernew);
	    boolean  validateUser(String email,String pass);
	
}
