package com.microservices.hotel.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.hotel.entity.HotelEntity;
import com.microservices.hotel.repo.HotelRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository hotRepo;

	public ResponseEntity<List<HotelEntity>> addMultipleHotelDetails(List<HotelEntity> hotEnt) {
			
		for(int i=0; i < hotEnt.size();i++) {
		String uid = UUID.randomUUID().toString();
		hotEnt.get(i).setHotelId(uid);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(hotRepo.saveAll(hotEnt));
	}

	public ResponseEntity<HotelEntity> addHotelDetails(HotelEntity hotEnt) {
		String uid = UUID.randomUUID().toString();
		hotEnt.setHotelId(uid);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotRepo.save(hotEnt));
	}

	public ResponseEntity<HotelEntity> getHotelDetailsById(String hotId) {

		Optional<HotelEntity> getById = hotRepo.findById(hotId);

		if (getById.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(getById.get());

		else
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public ResponseEntity<List<HotelEntity>> getAllHotelDetails(){
		
		return ResponseEntity.status(HttpStatus.OK).body(hotRepo.findAll());
	}
	
	public List<HotelEntity> allByName(String nm){
		
		return hotRepo.findAllByName(nm);
	}

	public HotelEntity singleByName(String nm){
		
		return hotRepo.findByName(nm);
	}

}
