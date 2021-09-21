package com.barclays.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.acc.model.Customer;
import com.barclays.acc.model.Users;
import com.barclays.acc.service.ManagerService;
import com.barclays.acc.service.UsersService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class UsersController {
	@Autowired
	UsersService userService;
	
	@GetMapping("/123")
	public String test() {
		return "test";
	}
	
	@PostMapping("/userLogin")
	public ResponseEntity<?> userLogin( @RequestBody Users user) {
		if(userService.login(user.getUserid(), user.getPassword(), user.getRoleid())) {
			return ResponseEntity.status(200).body("Successfully logged in");	
		}
		else {
			return ResponseEntity.status(401).body("Invalid Credentials");
	}
	}
	
	
	@PostMapping("/changePassword")
	public ResponseEntity<?> changePassword(@RequestBody ObjectNode objectnode) {
		
		int userid = Integer.parseInt(objectnode.get("userid").asText());
		String password = objectnode.get("password").asText();
		String newpassword = objectnode.get("newpassword").asText();
		if(userService.changePassword(userid, password, newpassword )) {
			return ResponseEntity.status(201).body("Changed Password Successfully");	
		}
		else {
			return ResponseEntity.status(401).body("Invalid Credentials"+newpassword);
		}
		
		
	}
}
