package com.microservices.apigateway.hotelratingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayHotelRatingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayHotelRatingAppApplication.class, args);
	}

}
