package com.stackroute.fridaysample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.stackroute.fridaysample")


public class FridaysampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FridaysampleApplication.class, args);
		
		System.out.println("Welcome to my App");
	}

}
