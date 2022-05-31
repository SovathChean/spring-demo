package com.example.sprintdemo.utility.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class BaseRuntimeException extends RuntimeException{
	
    private HttpStatus status;

    public BaseRuntimeException(String message){
        super(message);
    }
    
    public BaseRuntimeException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
    
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
