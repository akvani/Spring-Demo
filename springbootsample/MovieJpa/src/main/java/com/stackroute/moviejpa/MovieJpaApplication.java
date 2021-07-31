package com.stackroute.moviejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MovieJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieJpaApplication.class, args);
		System.out.println("Simple application");
	}

}
