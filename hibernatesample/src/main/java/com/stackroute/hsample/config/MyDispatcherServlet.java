package com.stackroute.hsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.stackroute.hsample")
public class MyDispatcherServlet {

	@Bean
	public InternalResourceViewResolver getResolver()
	{
		
		InternalResourceViewResolver iview=new InternalResourceViewResolver();
		iview.setPrefix("/WEB-INF/views/");
		
		iview.setSuffix(".jsp");
		
		return iview;
		
	}
	
	
	
}
