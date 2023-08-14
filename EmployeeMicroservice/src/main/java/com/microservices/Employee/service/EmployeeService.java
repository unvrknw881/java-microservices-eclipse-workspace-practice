package com.microservices.Employee.service;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.Employee.entity.EmployeeEntity;
import com.microservices.Employee.repo.EmployeeRepo;
import com.microservices.Employee.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo empRepo;
	
	@Autowired
	ModelMapper modMapper;
	
	@Autowired
	EmployeeResponse empres;
	
	public ResponseEntity<EmployeeEntity> addEmployees(EmployeeEntity empen){
		
		String uid = UUID.randomUUID().toString();
		empen.setId(uid);
		return ResponseEntity.status(HttpStatus.CREATED).body(empRepo.save(empen));
		
	}
	
	public ResponseEntity<EmployeeResponse> getUserById(String id){
		
		EmployeeEntity empen = empRepo.findById(id).get();
//		EmployeeResponse empres = modMapper.map(empen, EmployeeResponse.class);
//		Without using ModelMapper external dependency, we can use BeanUtils 
//		for duplicating or copying the variable values from one object to another object.
		
		BeanUtils.copyProperties(empen, empres);
		
		
			return ResponseEntity.status(HttpStatus.OK).body(empres);
		
		
		
	}
	
}
