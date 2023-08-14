package com.microservices.user.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class UserEntity {
	
	@Id
	String userId;
	String name;
	String email;
	String about;
	
	@Transient
	RatingEntity[] ratings;
	
	
	
//	Request Body
	
//	{
//		  "name": "siva",
//		  "email": "siva@gmail.com",
//		  "about": "A Java programmer."
//		  
//			
//		  
//		}
	

	
}
