package com.microservices.Address.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.Address.entity.AddressEntity;
import com.microservices.Address.response.AddressResponse;
import com.microservices.Address.service.AddressService;

@RestController
public class AddressControllers {
	
	@Autowired
	AddressService adSrvc;
	
	@GetMapping("/Address")
	private String address() {
		
		return "Andhrapradesh, kadapa, Jammalamadugu";
	}

	@PostMapping("/address")
	private ResponseEntity<AddressResponse> addAddress(@RequestBody AddressEntity AdEn){                  
		String uid = UUID.randomUUID().toString();
		AdEn.setId(uid);
		
		return adSrvc.provideAddress(AdEn);
		
		
	}

	@GetMapping("/address/{adrsId}")
	private ResponseEntity<AddressResponse> getAddressById(@PathVariable String adrsId){
		
		return adSrvc.addressByUserId(adrsId);
		
	}


}















