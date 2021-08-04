package com.stackroute.authorize.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.authorize.model.Userprofile;
import com.stackroute.authorize.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepo urepo;
	
	@Override
	public Userprofile addUser(Userprofile uobj) {
		 urepo.save(uobj);
		return uobj;
	}

	@Override
	public Userprofile validateLogin(String mailid, String pwd) {
		
		Userprofile uans=urepo.findByEmailidAndPassword(mailid, pwd);
		
		
		return uans;
	}

}
