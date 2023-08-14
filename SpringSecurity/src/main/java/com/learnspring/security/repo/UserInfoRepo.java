package com.learnspring.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnspring.security.entity.UserInfo;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, String>{

	Optional<UserInfo> findByUserName(String username);

}
