package com.example.sprintdemo.service;

import java.util.List;

import com.example.sprintdemo.dto.CheckOutDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CheckOutService {
	CheckOutDto save(CheckOutDto ckDto);
}
