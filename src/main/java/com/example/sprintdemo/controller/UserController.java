package com.example.sprintdemo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprintdemo.dto.UserDto;
import com.example.sprintdemo.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController  {
	
	@Autowired
	private final UserService userService;
	
	public UserController(UserService userService)
	{
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAll()
	{
		var users = userService.getList();
		
		return ResponseEntity.ok(users);
	}

}
