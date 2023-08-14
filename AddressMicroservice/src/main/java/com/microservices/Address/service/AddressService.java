package com.microservices.Address.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.Address.entity.AddressEntity;
import com.microservices.Address.repo.AddressRepo;
import com.microservices.Address.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	AddressRepo adrsRepo;

	@Autowired
	AddressResponse adrsRes;

	public ResponseEntity<AddressResponse> provideAddress(AddressEntity adEnt) {

		adrsRepo.save(adEnt);

		BeanUtils.copyProperties(adEnt, adrsRes);
		return ResponseEntity.status(HttpStatus.CREATED).body(adrsRes);

	}

	public ResponseEntity<AddressResponse> addressByUserId(String id) {

		Optional<AddressEntity> adEn = adrsRepo.findById(id);
//		return ResponseEntity.status(HttpStatus.OK).body(adrsRes);
		if (adEn.isPresent()) {
			BeanUtils.copyProperties(adEn.get(), adrsRes);
			return new ResponseEntity<>(adrsRes, HttpStatus.OK);
		}
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		

	}

}
