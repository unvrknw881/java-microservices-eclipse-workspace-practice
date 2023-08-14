package com.microservices.Employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.Employee.entity.EmployeeEntity;
import com.microservices.Employee.repo.EmployeeRepo;
import com.microservices.Employee.response.EmployeeResponse;
import com.microservices.Employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeRepo emprepo;
	
	@Autowired
	private EmployeeService empser;
	
	
	
	@GetMapping("/employee")
	private String employee() {
		
		String addrs = restTemplate.getForObject("http://localhost:8090/Address", String.class);
		
		return "Name: siva, empid: 689873, email: siva@gmail.com " + addrs;
	}
	
	@PostMapping("/employees")
	private ResponseEntity<EmployeeEntity> addEmployeeDetails(@Valid @RequestBody EmployeeEntity emen){
		
		
		return empser.addEmployees(emen);
		
	}
	
	@GetMapping("/employees/{id}")
	private ResponseEntity<EmployeeResponse> getEmployee(@PathVariable String id) {
		
//		Optional<EmployeeEntity> empen = emprepo.findById(id);
//		if(empen.isPresent()) 
//			return new ResponseEntity<>(empen.get(), HttpStatus.OK);
//		else
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;                                                
	
		return empser.getUserById(id);
	}
}
