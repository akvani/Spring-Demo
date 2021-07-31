package com.stackroute.universityapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class IbmSwagger {
	
	
	@Bean
	public Docket getdocketData()
	{
		
		return new Docket(DocumentationType.SWAGGER_2)
					     .select()
					     .apis(RequestHandlerSelectors.basePackage("com.stackroute.universityapp"))
					      .build()
					      .apiInfo(getapiinfo())
					      .useDefaultResponseMessages(false);
					      
	}
	
	public ApiInfo getapiinfo()
	{
		ApiInfoBuilder apibuild=new ApiInfoBuilder();
		apibuild.title("Ecommer APP")
		.description("This API helps to access mongo");
		
		
		return apibuild.build();
	}

}
