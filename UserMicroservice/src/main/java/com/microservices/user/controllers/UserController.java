package com.microservices.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.user.entity.UserEntity;
import com.microservices.user.exception.UserNotFoundException;
import com.microservices.user.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	UserService usrSrvc;
	
	@Autowired 
	Environment env;
	
	@GetMapping("/portcheck")
	public String runningPortCheck() {
		
		return "This application is running on port number: "+env.getProperty("local.server.port");
	}
	
	
	@GetMapping("/status/check")
	public String status() {
		
		return "Working";
	}
	
	@PostMapping
	private UserEntity addUser(@RequestBody UserEntity usrEnt){
		
			return usrSrvc.createUser(usrEnt);
	}
	@GetMapping("/{usrId}")
	private ResponseEntity<UserEntity> getUserById(@PathVariable String usrId) throws UserNotFoundException{                 
		
			return usrSrvc.findUsrById(usrId);
	}
	@GetMapping
	private List<UserEntity> getUsers(){
		
			return usrSrvc.findUsrs();
	}
	
	
}
