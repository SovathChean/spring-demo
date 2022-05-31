package com.example.sprintdemo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprintdemo.dto.UserDto;

import com.example.sprintdemo.service.UserService;

@RestController
@RequestMapping(value="register")
public class RegisterController {
	@Autowired
	private final UserService userService;
	
	public RegisterController(UserService userService)
	{
		this.userService = userService;
	}
	@PostMapping
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto user)
	{ 
		LocalDateTime now = LocalDateTime.now();
		user.setCreatedAt(now);
		UserDto userRegister = userService.save(user);
		
		return ResponseEntity.ok(userRegister);
	}
}
