package com.example.sprintdemo.service;

import com.example.sprintdemo.dto.UserDto;
import com.example.sprintdemo.model.UserModel;

import java.util.List;


public interface UserService {
 
	UserModel save(UserModel user);

	UserModel findUserById(Integer userId);

	List<UserModel> getList();
}
