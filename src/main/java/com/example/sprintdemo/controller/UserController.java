package com.example.sprintdemo.controller;

import java.util.List;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprintdemo.model.UserModel;
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
	
	@GetMapping(value = "/get-list")
	public ResponseEntity<List<UserModel>> getAll()
	{
		var users = userService.getList();
		
		return ResponseEntity.ok(users);
	}
	@PostMapping(value = "/register")
	public ResponseEntity<UserModel> registerUser(@RequestBody UserModel user)
	{ 
		LocalDateTime now = LocalDateTime.now();
		user.setCreatedAt(now);
		userService.save(user);
		
		return ResponseEntity.ok(user);
	}
}
