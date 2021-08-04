package com.stackroute.authorizeapp.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.authorizeapp.model.UserProfile;
import com.stackroute.authorizeapp.service.UserprofileService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("auth/user")
@CrossOrigin
public class UserController {

	
	@Autowired
	UserprofileService userservice;
	
	
	@PostMapping("/adduser")
	public ResponseEntity<?> adduser(@RequestBody UserProfile userobj)
	{
	UserProfile resultobj=	userservice.addUser(userobj);
	
	return new ResponseEntity<UserProfile>(resultobj,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> validatelogin(@RequestBody UserProfile userobj)
	{
		
		boolean res=userservice.validateUser(userobj.getEmailid(), userobj.getPassword() );
		
		if (res)
		{
			
			String mytoken=generateToken(userobj);
			HashMap mymap=new HashMap();
			mymap.put("token",mytoken);
			return new ResponseEntity<HashMap>(mymap , HttpStatus.OK);
		}
		else
			
			return new ResponseEntity<String>("Invalid credentials",HttpStatus.UNAUTHORIZED);
		
	}
	
	public String generateToken(UserProfile uprofile)
	{
		
		
		long expirytime=10_000_000;
		
		
		return Jwts.builder().setSubject(uprofile.getEmailid())
							   .setIssuedAt(new Date(System.currentTimeMillis()))
							   .setExpiration( new Date(System.currentTimeMillis()+expirytime))
							   .signWith(SignatureAlgorithm.HS256, "ibmkey")
							   .compact();
		
	}
	
	
}
