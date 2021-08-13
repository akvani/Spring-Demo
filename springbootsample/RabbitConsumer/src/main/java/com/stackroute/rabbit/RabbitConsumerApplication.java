package com.stackroute.rabbit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)


public class RabbitConsumerApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(RabbitConsumerApplication.class, args);
	}
	
	
@StreamListener(target=Sink.INPUT)

public void getproduct(Product product )

{
	System.out.println("New Product  added by producer is " + product.getProductname() + " price is " + product.getPrice());
	
}

}
