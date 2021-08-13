package com.stackroute.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class HystrixCircuitbalancApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = 	SpringApplication.run(HystrixCircuitbalancApplication.class, args);
	}

}
