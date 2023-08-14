package com.microservices.rating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.rating.entity.RatingEntity;
import com.microservices.rating.repository.RatingRepo;

@Service
public class RatingService {

	@Autowired
	RatingRepo rtngRepo;

	// add ratings to the database
	public ResponseEntity<RatingEntity> addRatings(RatingEntity rtngEnt) {

		return ResponseEntity.status(HttpStatus.CREATED).body(rtngRepo.save(rtngEnt));

	}

	// find all the ratings
	public ResponseEntity<List<RatingEntity>> getAllRatings() {

		return ResponseEntity.status(HttpStatus.OK).body(rtngRepo.findAll());
	}

	// get all the ratings that user has given with the particular user id that we
	// pass a pramenter.
	public ResponseEntity<List<RatingEntity>> getAllRatingsByUserId(String usrId) {

		return ResponseEntity.status(HttpStatus.OK).body(rtngRepo.findAllByUserId(usrId));
	}

	// get all the ratings by hotel id
	public ResponseEntity<List<RatingEntity>> getAllRatingsByHotelId(String htlId) {

		return ResponseEntity.status(HttpStatus.OK).body(rtngRepo.findAllByHotelId(htlId));
	}
}
