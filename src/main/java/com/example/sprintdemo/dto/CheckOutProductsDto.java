package com.example.sprintdemo.dto;

import org.springframework.beans.BeanUtils;

import com.example.sprintdemo.model.CheckOutModel;
import com.example.sprintdemo.model.CheckOutProducts;

public class CheckOutProductsDto {
	  private Integer id;
	  private Integer checkoutId;
	  private Integer productId;
	  public CheckOutProductsDto(CheckOutProducts ckProducts) {
	        BeanUtils.copyProperties(ckProducts, this, "checkoutId");

	        CheckOutModel ckModel = ckProducts.getCheckout();
	        if (ckModel != null) {
	            this.checkoutId = ckModel.getId();
	        }
	    }
	public CheckOutProductsDto() {
		super();
	}
	public CheckOutProductsDto(Integer id, Integer checkoutId, Integer productId) {
		super();
		this.id = id;
		this.checkoutId = checkoutId;
		this.productId = productId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCheckoutId() {
		return checkoutId;
	}
	public void setCheckoutId(Integer checkoutId) {
		this.checkoutId = checkoutId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}


}
