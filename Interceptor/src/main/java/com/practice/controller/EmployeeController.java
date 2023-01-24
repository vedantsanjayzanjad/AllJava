package com.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/employee")
public class EmployeeController {

	@GetMapping
	public String getEmployee()
	{
		return "VEdant";
	}
}
