package com.microservices.user.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	//custom exception
	public Map<String, String> userNotFound(UserNotFoundException ex){
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("Error Message", ex.getMessage());
		return errorMap;
	}

}
