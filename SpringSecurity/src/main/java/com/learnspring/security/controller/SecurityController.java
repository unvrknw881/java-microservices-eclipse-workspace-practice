package com.learnspring.security.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class SecurityController {
	
	@GetMapping("/publicurl/output")
	public String checkingSpringSecurity() {
		
		return "Hi there, this endpoint is working fine!";
	}
	
	@GetMapping("/currentuser")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String getUsrNm(Principal obj) {
		
		return obj.getName();
	}

}
