package com.microservices.Employee;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.microservices.Employee.response.EmployeeResponse;

@Configuration
public class EmployeeAppConfig {

	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
	
	@Bean
	public ModelMapper modMapper() {
		
		return new ModelMapper();
	}
	
//	commented this bean because i have annotated EmployeeResponse class with @Component.
//	Both function and annotation works fine does not give any error.
//	@Bean
//	public EmployeeResponse empres() {
//		return new EmployeeResponse();
//	}
//	
	
	
}
