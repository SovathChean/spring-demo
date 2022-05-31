package com.example.sprintdemo.exception;

import org.springframework.http.HttpStatus;

import com.example.sprintdemo.utility.exception.BaseRuntimeException;


public class ResourceNotFoundException extends BaseRuntimeException
{
	  public ResourceNotFoundException(Integer id) {
	        super("Resource with " + id + " not found", HttpStatus.NOT_FOUND);
	    }
}
