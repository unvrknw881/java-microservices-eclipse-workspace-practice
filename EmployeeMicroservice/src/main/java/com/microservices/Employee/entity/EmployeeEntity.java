package com.microservices.Employee.entity;

import org.springframework.stereotype.Component;

import com.microservices.Employee.response.AddressResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EmployeeEntity {
	
	@Id
	String id;
	
	@NotNull(message="Email should not be null")
	@Email(message = "Please enter valid email")
	String email;
	
	
	String bloodGroup;
	
	@Size(min=3, max=20, message="Employee name should have atleast 3 characters")
	String employeeName;
	
	@Transient
	AddressResponse adrs;
	
	
//	Request body
//	{
//		  "email": "nageshwarareddy@gmail.com",
//		  "bloodGroup": "A positive",
//		  "employeeName": "Nageshwara Reddy"
//		  
//		}
//	
	
	
	
	
	
	}











