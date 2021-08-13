package com.stackroute.universityapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//import com.stackroute.universityapp.filter.UniversityFilter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UniversityappApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityappApplication.class, args);
	}

	
//	
//	@Bean
//	
//	public FilterRegistrationBean getfilterbean()
//	{
//		
//		UrlBasedCorsConfigurationSource urlcorsobj=new UrlBasedCorsConfigurationSource();
//		
//		CorsConfiguration corsconfig=new CorsConfiguration();
//		
//		corsconfig.setAllowCredentials(true);
//		corsconfig.addAllowedOrigin("*");
//		corsconfig.addAllowedMethod("*");
//		corsconfig.addAllowedHeader("*");
//
//		urlcorsobj.registerCorsConfiguration("/**", corsconfig);	
//		
//		FilterRegistrationBean fbean=new FilterRegistrationBean(new UniversityFilter());
//		
//		fbean.addUrlPatterns("/university/*");
//		
//		return fbean;
//	}
}















