package com.barclays.acc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.acc.model.Account;
import com.barclays.acc.model.Customer;
import com.barclays.acc.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/viewAcc/{customerid}")
	public ResponseEntity<?> viewAccount(@PathVariable int customerid) {
		List<Account> accounts = customerService.viewAccounts(customerid);
		return ResponseEntity.status(200).body(accounts);
	}
}
