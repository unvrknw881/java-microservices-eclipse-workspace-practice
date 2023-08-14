package com.microservices.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class HotelEntity {
	
	@Id
	String hotelId;
	String name;
	String location;//we can store logitude and lattitude also in location if we want.
	String about;
	
	
//	RequestBody
//	[{
//	    
//	    "name": "KGF hotel", 
//	    "location": "Y junction",
//	    "about": "Mandi biryani is also available."
//	  
//	},
//	 {
//	    
//	    "name": "Abhiruchi", 
//	    "location": "Near Campbell hospital",
//	    "about": "All veg and non-veg items are available here."
//	  
//	}
//
//
//	]
	

}




