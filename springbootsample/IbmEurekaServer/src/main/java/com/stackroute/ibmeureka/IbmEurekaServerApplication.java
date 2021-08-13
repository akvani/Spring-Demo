package com.stackroute.ibmeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class IbmEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbmEurekaServerApplication.class, args);
	}

}
