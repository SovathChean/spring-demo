package com.example.sprintdemo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sprintdemo.dto.CheckOutDto;
import com.example.sprintdemo.utility.validation.BaseValidator;
import com.example.sprintdemo.utility.validation.CommonValidatorUtils;

@Component
public class CheckOutModelValidator implements BaseValidator<CheckOutDto> {
	  
	private final CommonValidatorUtils commonValidatorUtils ;
	@Autowired
    public CheckOutModelValidator(
            CommonValidatorUtils commonValidatorUtils) {
        this.commonValidatorUtils = commonValidatorUtils;
    }
	@Override
	public void validate(CheckOutDto obj) {
//		  this.commonValidatorUtils.validateRequiredField("userId", obj.getUserId());
//		  this.commonValidatorUtils.validateRequiredField("product", obj.getItems());	
	}

}
