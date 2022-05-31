package com.example.sprintdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sprintdemo.model.UserModel;
import com.example.sprintdemo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
	private UserRepository userRepo;

	public UserModel save(UserModel student) {
		return userRepo.save(student);
	}

	public UserModel findUserById(Integer studentId) {
		return userRepo.findUserById(studentId);
	}

	public List<UserModel> getList() {
		return userRepo.findAll();
	}
}
