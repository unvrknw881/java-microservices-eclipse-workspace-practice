package com.microservices.Employee.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class EmployeeResponse {

	String id;
	String email;
	String bloodGroup;
	String employeeName;
}
