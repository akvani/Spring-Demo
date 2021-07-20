package com.stackroute.universityapp.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.stackroute.universityapp.model.University;

@Aspect
@Component
public class UniversityAspect {
	
	Logger universelog=LoggerFactory.getLogger(UniversityAspect.class);
	
	@Before("adduniversityhandler()")
	public void getuniversedata(JoinPoint  jp)
	{
		universelog.info("new university is getting added");
	}
	

	@Before("execution (* com.stackroute.universityapp.controller.UniversityController.show(..))")
	public void showdata(JoinPoint  jp)
	{
		universelog.info("data retrived");
	}
	
	
	
	@Around("execution (* com.stackroute.universityapp.controller.UniversityController.saveuniverse(..))")
	public Object aroundsaveuniverse(ProceedingJoinPoint proceedobj) throws Throwable
	{
		
       Object obj=proceedobj.proceed();		
     
     	ResponseEntity resentity=(ResponseEntity)obj;
     	try
     	{
    		University universe=(University)resentity.getBody();
     	universelog.info("client added university named " + universe.getUniversityname() + " of id " + universe.getUniversityid() );
     		
     	}
		catch(Exception e)
     	{
			universelog.warn("Save call is not success whil adding university. Excepiton raised" + e.getMessage());
     	}
     	
     	return obj;
		
	}
	
	@AfterThrowing(pointcut="adduniversityhandler()",throwing="exceptobj")
	public void addexceptionhandler(Exception exceptobj)
	{
		universelog.warn("Exception raised while add" + exceptobj);
	}
	
	
	@Pointcut("execution (* com.stackroute.universityapp.controller.UniversityController.saveuniverse(..))")
	public void adduniversityhandler()
	{
		
	}

}




