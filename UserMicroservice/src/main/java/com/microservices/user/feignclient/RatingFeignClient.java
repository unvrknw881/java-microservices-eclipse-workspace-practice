package com.microservices.user.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.user.entity.RatingEntity;  

@FeignClient(name = "RatingMicroservice", url="localhost:7002", path="/ratingsrvc")
public interface RatingFeignClient {
	
	@GetMapping("/allratingsuserid/{userId}")
	RatingEntity[] allRatingsByUserId(@PathVariable String userId);                                  
		
		
	

}
