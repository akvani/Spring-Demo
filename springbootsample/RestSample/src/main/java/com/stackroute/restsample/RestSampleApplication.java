package com.stackroute.restsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.stackroute.restsample")
public class RestSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSampleApplication.class, args);
		
		System.out.println("Rest api started");
	}

}
