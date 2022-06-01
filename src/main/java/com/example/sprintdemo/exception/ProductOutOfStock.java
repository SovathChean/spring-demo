package com.example.sprintdemo.exception;

import org.springframework.http.HttpStatus;

import com.example.sprintdemo.utility.exception.BaseRuntimeException;

public class ProductOutOfStock extends BaseRuntimeException{
	 public ProductOutOfStock(String productName) {
	        super("Resource with " + productName + " not found", HttpStatus.NOT_FOUND);
	    }
}
