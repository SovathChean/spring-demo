package com.example.sprintdemo.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateRequest {
	  private String name;

	public void setName(String newName) {
		this.name = name;
		
	}
}
