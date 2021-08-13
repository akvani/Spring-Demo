package com.stackroute.authorize.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.authorize.model.Userprofile;
import com.stackroute.authorize.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin

public class UserController
{
   @Autowired
   UserService uservice;
   
   
   
   @RequestMapping("/adduser")
   public ResponseEntity<?> storeuser(@RequestBody Userprofile uprofile)
   {
	   System.out.println(uprofile.getEmailid());
	   Userprofile result=uservice.addUser(uprofile);
	   return new ResponseEntity<Userprofile>(uprofile,HttpStatus.OK);
   }
   
   
   
   @PostMapping("/login")
   
   public ResponseEntity<?> login(@RequestBody Userprofile uprofile)
   {
  Userprofile result=uservice.validateLogin(uprofile.getEmailid(), uprofile.getPassword());
  if (result==null)
	  return new ResponseEntity<String>("Invalid user",HttpStatus.UNAUTHORIZED);
  
	String tokendata=generateToken(result);   
	   HashMap hashmap = new HashMap();
	   hashmap.put("token",tokendata);
	   
	   return new ResponseEntity<HashMap>(hashmap,HttpStatus.OK);
	   
   }
   
   
   public String generateToken(Userprofile uprofile)
   {
	   
	   long duration=10_000_00;
	  return Jwts.builder().setSubject(uprofile.getEmailid())
			  	           .setIssuedAt(new Date(System.currentTimeMillis()))
			  	           .setExpiration(new Date(System.currentTimeMillis()+duration))
			  	           .signWith(SignatureAlgorithm.HS256, "ibmfsd")
			  	           .compact();
	   
   }
   
   
   
   
}
