package com.barclays.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.acc.service.ManagerService;

@RestController
public class ManagerController {
	
	@Autowired
	ManagerService employeeService;
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
