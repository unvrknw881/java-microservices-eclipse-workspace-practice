package com.microservices.user.entity;

import lombok.Data;

@Data
public class RatingEntity {

	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	
	private HotelDTO hotel;
	
	
}
