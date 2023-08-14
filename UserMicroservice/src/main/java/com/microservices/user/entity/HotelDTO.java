package com.microservices.user.entity;

import lombok.Data;

@Data
public class HotelDTO {

	String hotelId;
	String name;
	String location;//we can store logitude and lattitude also in location if we want.
	String about;
	
	
}
