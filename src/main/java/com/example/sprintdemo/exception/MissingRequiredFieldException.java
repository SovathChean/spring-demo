package com.example.sprintdemo.exception;

import org.springframework.http.HttpStatus;

import com.example.sprintdemo.utility.exception.BaseRuntimeException;

public class MissingRequiredFieldException extends BaseRuntimeException{

	public MissingRequiredFieldException(String message) {
		
		super("Field '" + message + " is required", HttpStatus.BAD_REQUEST);
	}
	

}
