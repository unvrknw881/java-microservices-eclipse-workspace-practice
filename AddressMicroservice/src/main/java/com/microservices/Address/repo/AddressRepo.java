package com.microservices.Address.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.Address.entity.AddressEntity;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, String>{
	

}
