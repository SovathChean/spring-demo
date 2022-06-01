package com.example.sprintdemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sprintdemo.model.CheckOutModel;

@Repository
public interface CheckOutDao extends JpaRepository<CheckOutModel, Integer> {
	Optional<CheckOutModel> findCheckOutById(Integer checkoutId);
}
