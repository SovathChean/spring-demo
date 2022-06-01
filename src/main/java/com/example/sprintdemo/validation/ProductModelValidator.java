package com.example.sprintdemo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sprintdemo.dto.ProductDto;
import com.example.sprintdemo.model.ProductModel;
import com.example.sprintdemo.utility.validation.BaseValidator;
import com.example.sprintdemo.utility.validation.CommonValidatorUtils;

@Component
public class ProductModelValidator implements BaseValidator<ProductDto> {
	    private final CommonValidatorUtils commonValidatorUtils ;

	    @Autowired
	    public ProductModelValidator(
	            CommonValidatorUtils commonValidatorUtils) {
	        this.commonValidatorUtils = commonValidatorUtils;
	    }
		@Override
		public void validate(ProductDto obj) {
			  this.commonValidatorUtils.validateRequiredField("productName", obj.getProductName());
			  this.commonValidatorUtils.validateRequiredField("productCode", obj.getProductCode());
			  this.commonValidatorUtils.validateRequiredField("updatedBy", obj.getCreatedBy());
		}
}
