package com.microservices.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.user.entity.HotelDTO;
import com.microservices.user.entity.RatingEntity;
import com.microservices.user.entity.UserEntity;
import com.microservices.user.exception.UserNotFoundException;
import com.microservices.user.feignclient.RatingFeignClient;
import com.microservices.user.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository usrRepo;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	RatingFeignClient rtngFeignClient;

	public UserEntity createUser(UserEntity usr) {

		String uid = UUID.randomUUID().toString();
		usr.setUserId(uid);

		return usrRepo.save(usr);
	}

	public ResponseEntity<UserEntity> findUsrById(String usrId) throws UserNotFoundException {

		// http://localhost:7002/allratingsuserid/{userId}
		UserEntity usrFind = usrRepo.findById(usrId)
				.orElseThrow(() -> new UserNotFoundException("User not found with the id: " + usrId));
		
//		ArrayList<RatingEntity> ratingsUsrId = restTemplate
//				.getForObject("http://localhost:7002/allratingsuserid/" + usrId, ArrayList.class);
		
		//using rest template
//		RatingEntity[] ratingsUsrId = restTemplate
//				.getForObject("http://localhost:7002/allratingsuserid/" + usrId, RatingEntity[].class);
		
		//using feign client
		RatingEntity[] ratingsUsrId = rtngFeignClient.allRatingsByUserId(usrId);
		
		usrFind.setRatings(ratingsUsrId);
		
		
		for (int i = 0; i < ratingsUsrId.length; i++) {
			
			String hotId = ratingsUsrId[i].getHotelId();
			HotelDTO hotel = restTemplate.getForObject("http://localhost:7001/hotelsrvc/hotelbyid/"+hotId, HotelDTO.class);
			ratingsUsrId[i].setHotel(hotel);
		}

		
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body(usrFind);
//		if (usrFind.isPresent())

//			return ResponseEntity.status(HttpStatus.OK).body(usrFind.get());
//		else
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	public List<UserEntity> findUsrs() {
		List<UserEntity> allUsrs = (List<UserEntity>) usrRepo.findAll();
		

		return allUsrs;
	}

}
