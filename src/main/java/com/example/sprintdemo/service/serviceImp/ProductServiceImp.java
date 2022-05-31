package com.example.sprintdemo.service.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sprintdemo.dao.ProductDao;
import com.example.sprintdemo.dto.ProductDto;
import com.example.sprintdemo.exception.ResourceNotFoundException;
import com.example.sprintdemo.model.ProductModel;
import com.example.sprintdemo.service.ProductService;
import com.example.sprintdemo.validation.ProductModelValidator;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	public ProductDao productDao;
	@Autowired
	public ProductModelValidator productModelValidator;
	@Override
	public ProductDto save(ProductDto productDto) {
		this.productModelValidator.validate(productDto);
		ProductModel product = this.dtoToEntity(productDto);
		productDao.save(product);
		return new ProductDto(product);
	}
	@Override
	public ProductDto findProductById(Integer productId) {
		ProductModel product = productDao.findProductById(productId).orElseThrow(() -> new ResourceNotFoundException(productId));
		return new ProductDto(product);
	}
	@Override
	public List<ProductDto> getList() {
		var products = productDao.findAll();
		
		return products.stream().map(product -> new ProductDto(product)).collect(Collectors.toList());
	}
	private ProductModel dtoToEntity(ProductDto productDto) {
	        ProductModel product = new ProductModel();
	        BeanUtils.copyProperties(productDto, product);
	        return product;
	}

}
