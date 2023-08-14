package com.microservices.rating.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RatingEntity {

	
	private String userId;
	private String hotelId;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String ratingId;
	private long rating;
	private String feedback;
	
	
//	Sample Request body
//	{
//		"userId": "",
//		"hotelId": "",
//		"rating": ,
//		"feedback": ""
//	}
	
	
}
