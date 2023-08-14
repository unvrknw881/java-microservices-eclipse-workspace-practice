package com.microservices.Address.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AddressResponse {

	String id;

	String pincode;

	String city;

	String streetName;

	String doorNumber;

	String state;

}
