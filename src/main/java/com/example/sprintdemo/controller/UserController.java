package com.example.sprintdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprintdemo.model.UserModel;
import com.example.sprintdemo.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/get-list")
	public ResponseEntity<List<UserModel>> getAll()
	{
		var users = userService.getList();
		return ResponseEntity.ok(users);
	}
	
}
