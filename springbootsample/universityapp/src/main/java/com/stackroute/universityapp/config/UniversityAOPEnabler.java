package com.stackroute.universityapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class UniversityAOPEnabler 
{

	
	@Bean
	public UniversityAspect getuniversityaspect()
	{
		return new UniversityAspect();
	}
	
}
