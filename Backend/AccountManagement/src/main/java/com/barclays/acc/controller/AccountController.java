package com.barclays.acc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.acc.service.AccountService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController
//@RequestMapping("/")
public class AccountController {
	@Autowired
	private  AccountService accountService;
	
	@GetMapping("/")
	public String test() {
		return "Hello World";
	}
	@PostMapping("/transfer")
	public String fundTransfer(@RequestParam Object obj ) {
		System.out.println(obj);
		return obj.toString();
		
	}	

}
