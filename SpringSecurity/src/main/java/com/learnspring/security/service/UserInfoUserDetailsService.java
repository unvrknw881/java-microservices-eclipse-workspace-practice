package com.learnspring.security.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.learnspring.security.entity.UserInfo;
import com.learnspring.security.repo.UserInfoRepo;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserInfoRepo usrInfRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
	Optional<UserInfo> usr = usrInfRepo.findByUserName(username);
		
		return null;
	}

}
