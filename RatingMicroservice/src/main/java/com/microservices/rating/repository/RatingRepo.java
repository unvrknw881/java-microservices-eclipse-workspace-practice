package com.microservices.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.rating.entity.RatingEntity;

public interface RatingRepo extends JpaRepository<RatingEntity, String>{

	//custom finder methods
	List<RatingEntity> findAllByUserId(String userId);
	List<RatingEntity> findAllByHotelId(String hotelId);
	
}
