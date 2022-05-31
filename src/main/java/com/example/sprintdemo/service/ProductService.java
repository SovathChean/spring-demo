package com.example.sprintdemo.service;

import java.util.List;

import com.example.sprintdemo.dto.ProductDto;

public interface ProductService {
	ProductDto save(ProductDto productDto);

	ProductDto findProductById(Integer productId);

	List<ProductDto> getList();
}
