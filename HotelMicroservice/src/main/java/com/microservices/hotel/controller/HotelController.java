package com.microservices.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.hotel.entity.HotelEntity;
import com.microservices.hotel.service.HotelService;

@RestController
@RequestMapping("hotelsrvc")
public class HotelController {
	
	@Autowired
	HotelService hotSrvc;
	
	@Autowired
	Environment env;
	
	@GetMapping("/portcheck")
	public String runningPortCheck() {
		
		return "This application is running on port number: "+env.getProperty("local.server.port");
	}
	
	@PostMapping("/hotels")
	private ResponseEntity<List<HotelEntity>> addHotels(@RequestBody List<HotelEntity> hotEnt){
		
		return hotSrvc.addMultipleHotelDetails(hotEnt);
	}
	
	@PostMapping("/hotel")
	private ResponseEntity<HotelEntity> addHotel(@RequestBody HotelEntity hotEnt){
		
		return hotSrvc.addHotelDetails(hotEnt);
	}
	
	@GetMapping("/hotelbyid/{hotId}")
	private ResponseEntity<HotelEntity> hotelById(@PathVariable String hotId){
	
		return hotSrvc.getHotelDetailsById(hotId);
	}
	
	@GetMapping("/allhotels")
	private ResponseEntity<List<HotelEntity>> multipleHotels(){
	
		return hotSrvc.getAllHotelDetails();
	}
	
	@GetMapping("/allhotels/{name}")
	private List<HotelEntity> multipleHotelsCustom(@PathVariable String name){
	
		return hotSrvc.allByName(name);
	}
	
	@GetMapping("/hotel/{name}")
	private HotelEntity multipleHotelsCustomSingle(@PathVariable String name){
	
		return hotSrvc.singleByName(name);
	}
	
	
	

}
