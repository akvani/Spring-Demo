package com.stackroute.moviejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieJpaApplication.class, args);
		System.out.println("Simple application");
	}

}
