package com.example.sprintdemo.dto;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;

import com.example.sprintdemo.model.CheckOutModel;
import com.example.sprintdemo.model.CheckOutProducts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckOutDto {
	
	  private Integer id;
	  private Integer userId;
	  private List<CheckOutProductsDto> products = new ArrayList<>();
	  public CheckOutDto(CheckOutModel checkOut) {
	        BeanUtils.copyProperties(checkOut, this, "products");
	        List<CheckOutProducts> products = checkOut.getProducts();
	        if(products != null && products.size() > 0) {
	        	products.forEach(product -> {
	        		CheckOutProductsDto productDto = new CheckOutProductsDto(product);
	                this.products.add(productDto);
	            });
	        }
	    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<CheckOutProductsDto> getProducts() {
		return products;
	}
	public void setProducts(List<CheckOutProductsDto> products) {
		this.products = products;
	}
	public CheckOutDto(Integer id, Integer userId, List<CheckOutProductsDto> products) {
		super();
		this.id = id;
		this.userId = userId;
		this.products = products;
	}
	public CheckOutDto() {
		super();
		// TODO Auto-generated constructor stub
	}
      
}
