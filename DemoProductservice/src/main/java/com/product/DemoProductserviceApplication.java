package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DemoProductserviceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoProductserviceApplication.class, args);
	}

}
