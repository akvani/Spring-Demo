package com.stackroute.authorize.service;

import com.stackroute.authorize.model.Userprofile;

public interface UserService {

    Userprofile addUser(Userprofile uobj);
    Userprofile validateLogin(String mailid,String pwd);
	
}
