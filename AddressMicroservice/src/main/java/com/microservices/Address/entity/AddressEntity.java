package com.microservices.Address.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Component
@Data
public class AddressEntity {
	
	@Id
	String id;
	
	String pincode;
	
	String city;
	
	String streetName;
	
	String doorNumber;
	
	String state;
	
//	Request body
//	{
//		  "pincode": "516434",
//			
//		  "city": "Jammalamadugu",
//			
//		  "streetName": "Kapu street",
//			
//		  "doorNumber": "7/38",
//			
//		  "state": "Andhra Pradesh",
//			
//		  
//		}

}
