package com.microservices.rating.controller;

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

import com.microservices.rating.entity.RatingEntity;
import com.microservices.rating.service.RatingService;

@RestController
@RequestMapping("/ratingsrvc")
public class RatingController {
	
	@Autowired
	RatingService rtngSrvc;
	
	@Autowired
	Environment env;
	
	
	@GetMapping("/portcheck")
	public String runningPortCheck() {
		
		return "This application is running on port number: "+env.getProperty("local.server.port");
	}
	
	
	@PostMapping("/rating")
	private ResponseEntity<RatingEntity> createRating(@RequestBody RatingEntity rtngEn){
		
		return rtngSrvc.addRatings(rtngEn);
	}
	
	@GetMapping("/allratings")
	private ResponseEntity<List<RatingEntity>> allRatings(){
		
		return rtngSrvc.getAllRatings();
	}
	
	@GetMapping("/allratingsuserid/{userId}")
	private ResponseEntity<List<RatingEntity>> allRatingsByUserId(@PathVariable String userId){
		
		return rtngSrvc.getAllRatingsByUserId(userId);
		
	}
	
	@GetMapping("/allratingshotelid/{hotelId}")
	private ResponseEntity<List<RatingEntity>> allRatingsByHotelId(@PathVariable String hotelId){
		
		return rtngSrvc.getAllRatingsByHotelId(hotelId);
		
	}

}




