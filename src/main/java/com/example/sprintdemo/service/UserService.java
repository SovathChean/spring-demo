package com.example.sprintdemo.service;

import com.example.sprintdemo.dto.UserDto;


import java.util.List;


public interface UserService {
 
	UserDto save(UserDto user);
	
	UserDto findUserById(Integer userId);

	List<UserDto> getList();
}
