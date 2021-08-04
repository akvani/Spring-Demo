package com.stackroute.authorizeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.authorizeapp.model.UserProfile;
import com.stackroute.authorizeapp.repository.UserRepo;


@Service
public class UserprofileServiceImpl  implements UserprofileService{

	
	@Autowired
	UserRepo userrepo;
	
	@Override
	public UserProfile addUser(UserProfile usernew) {
		
		UserProfile result= userrepo.save(usernew);
		return result;
	}

	@Override
	public boolean validateUser(String email, String pass) {
		
	
		UserProfile uprofile=userrepo.findByEmailidAndPassword(email, pass);
		
		if (uprofile==null)
		return false;
		else
			return true;
		
	}

}
