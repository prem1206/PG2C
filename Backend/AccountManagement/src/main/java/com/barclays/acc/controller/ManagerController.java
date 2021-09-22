package com.barclays.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.acc.model.Customer;
import com.barclays.acc.service.ManagerService;

@RestController
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@PostMapping("/newAcc")
	public ResponseEntity<?> createAccount(@RequestBody Customer customer) {
		managerService.createNewAccount(customer);
		return ResponseEntity.status(201).body("successfully created");
	}
}
