package com.example.sprintdemo.utility.validation;

import org.springframework.stereotype.Component;

import com.example.sprintdemo.exception.MissingRequiredFieldException;

@Component
public class CommonValidatorUtils<T, S>{
	
    public void validateRequiredField(String fieldLabel, T fieldValue) {
        if(fieldValue == null)
            throw new MissingRequiredFieldException(fieldLabel);
    }
}
