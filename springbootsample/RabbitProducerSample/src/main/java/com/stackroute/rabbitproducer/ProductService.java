package com.stackroute.rabbitproducer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProductService {

	@Output("ibmfsd")
	MessageChannel		getProductdata();
	
}
