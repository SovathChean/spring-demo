package com.example.sprintdemo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprintdemo.dto.ProductDto;
import com.example.sprintdemo.service.ProductService;

@RestController
@RequestMapping(value="products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	public ProductController(ProductService productService)
	{
		this.productService = productService;
	}
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAll()
	{
		var products = productService.getList();
		
		return ResponseEntity.ok(products);
	}
	@PostMapping
	public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto)
	{ 
		LocalDateTime now = LocalDateTime.now();
		productDto.setCreatedAt(now);
		ProductDto createProduct = productService.save(productDto);
		
		return ResponseEntity.ok(createProduct);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> put(@PathVariable(value = "id") Integer productId, @RequestBody ProductDto productDto)
	{
		ProductDto oldProduct = productService.findProductById(productId);
		LocalDateTime now = LocalDateTime.now();
		if(oldProduct == null)
			return (ResponseEntity<ProductDto>) ResponseEntity.notFound();
		oldProduct.setProductCode(productDto.getProductCode());
		oldProduct.setProductName(productDto.getProductName());
		oldProduct.setQty(productDto.getQty());
		oldProduct.setUpdatedAt(now);
		oldProduct.setUpdatedBy(productDto.getUpdatedBy());
		
		productService.save(oldProduct);
		return ResponseEntity.ok(oldProduct);
		
	}
	
}
