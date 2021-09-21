package com.barclays.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.acc.service.ManagerService;
import com.barclays.acc.service.UsersService;

@RestController
public class UsersController {
	@Autowired
	UsersService userService;
	
	@GetMapping("/123")
	public String test() {
		return "test";
	}
}
