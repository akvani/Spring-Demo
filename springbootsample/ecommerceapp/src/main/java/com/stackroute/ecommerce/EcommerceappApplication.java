package com.stackroute.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.stackroute.ecommerce.filter.EcommFilter;
import com.stackroute.ecommerce.model.Movie;
import com.stackroute.ecommerce.service.CustomerService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableBinding(Sink.class)

@EnableSwagger2
public class EcommerceappApplication {

	
	@Autowired
	CustomerService custservice;
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceappApplication.class, args);
	}
	

	
	@StreamListener(target=Sink.INPUT)

	public void getproduct(Movie movie )

	{
		System.out.println("moviename" + movie.getMoviename() + "movieid" + movie.getMovieid());
		custservice.addMovie(movie);
		
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
		
		FilterRegistrationBean fbean=new FilterRegistrationBean(new EcommFilter());
		
		fbean.addUrlPatterns("/abc/*");
		
		return fbean;
	}


}
