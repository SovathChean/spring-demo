package com.example.sprintdemo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sprintdemo.model.UserModel;
import com.example.sprintdemo.utility.validation.BaseValidator;
import com.example.sprintdemo.utility.validation.CommonValidatorUtils;

@Component
public class UserModelValidator implements BaseValidator<UserModel> {
	  private final CommonValidatorUtils commonValidatorUtils;

	    @Autowired
	    public UserModelValidator(
	            CommonValidatorUtils commonValidatorUtils) {
	        this.commonValidatorUtils = commonValidatorUtils;
	    }
		@Override
		public void validate(UserModel obj) {
			  this.commonValidatorUtils.validateRequiredField("username", obj.getUsername());
			  this.commonValidatorUtils.validateRequiredField("gender", obj.getGender());
			  this.commonValidatorUtils.validateRequiredField("dob", obj.getDob());
			  this.commonValidatorUtils.validateRequiredField("createdBy", obj.getCreatedBy());
		}
}
