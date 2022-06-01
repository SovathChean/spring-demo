package com.example.sprintdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprintdemo.dto.CheckOutDto;
import com.example.sprintdemo.service.CheckOutService;
@RestController
@RequestMapping(value="checkout")
public class CheckOutController {
	@Autowired
	private CheckOutService ckService;
	public CheckOutController(CheckOutService ckService)
	{
		this.ckService = ckService;
	}
	@PostMapping
	public ResponseEntity<CheckOutDto> save(@RequestBody CheckOutDto ckDto)
	{
		ckDto.setId(null);
 		ckService.save(ckDto);
		return ResponseEntity.ok(ckDto);
	}
}
