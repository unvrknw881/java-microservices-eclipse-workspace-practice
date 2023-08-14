package com.microservices.hotel.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.hotel.entity.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity, String>{

	List<HotelEntity> findAllByName(String name);
	HotelEntity findByName(String name);
	
}
