package com.example.zuulsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@SpringBootApplication
public class ZuulsampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulsampleApplication.class, args);
	}
	
	
	@Bean
	
	public Myprefilter getprefilter()
	{
		return new Myprefilter();
	}
	
	@Bean
	
	public FilterRegistrationBean getfilterbean()
	{
		
		UrlBasedCorsConfigurationSource urlcorsobj=new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration corsconfig=new CorsConfiguration();
		
		corsconfig.setAllowCredentials(true);
		corsconfig.addAllowedOrigin("*");
		corsconfig.addAllowedMethod("*");
		corsconfig.addAllowedHeader("*");

		urlcorsobj.registerCorsConfiguration("/**", corsconfig);	
		
		FilterRegistrationBean fbean=new FilterRegistrationBean(new Myjwtfilter());
		
		fbean.addUrlPatterns("/universityapp/university/*","/restclient/*");
		
		return fbean;
	}

}
