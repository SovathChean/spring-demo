package com.example.sprintdemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sprintdemo.model.ProductModel;

public interface ProductDao extends JpaRepository<ProductModel, Integer> {
	
	   Optional<ProductModel> findProductById(Integer id);
}
