package com.microservices.user.repo;

import org.springframework.data.repository.CrudRepository;

import com.microservices.user.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, String> {

}
