package com.springbootrediscacheexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 5966006566406891298L;
	
	public StudentNotFoundException(String message) {
		super(message);
	}

}
