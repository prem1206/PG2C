package com.barclays.acc.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.acc.model.AccountTransaction;
import com.barclays.acc.service.AccountService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@RestController
public class AccountController {
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	static class FundObj{
	 int acc1,acc2,amount;	
	}
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	static class moneyObj{
		int acc,amount;
	}
	
	@Autowired
	private  AccountService accountService;
	
	@GetMapping("/")
	public String test() {
		return "Hello World";
	}
	@PostMapping("/fundtransfer")
	public ResponseEntity<?> fundTransfer(@RequestBody FundObj obj ) {
		accountService.fundTransfer(obj.getAcc1(), obj.getAcc2(), obj.getAmount());
		return ResponseEntity.status(201).body("successfully Fund Tranfered");
		
	}	
	@GetMapping("/checkbalance/{acc}")
	public ResponseEntity<?> checkbalance(@PathVariable int acc ) {
		int balance = accountService.checkBalance(acc);
		return ResponseEntity.status(201).body("Balance in Account "+acc+" is "+balance);
		
	}	
	@PostMapping("/addmoney")
	public ResponseEntity<?> addMoney(@RequestBody moneyObj obj ) {
		accountService.addMoney(obj.getAcc(), obj.getAmount());
		return ResponseEntity.status(201).body("successfully Fund added to "+obj.getAcc());
		
	}
	@PostMapping("/withdraw")
	public ResponseEntity<?> withDraw(@RequestBody moneyObj obj ) {
		accountService.withdrawMoney(obj.getAcc(), obj.getAmount());
		return ResponseEntity.status(201).body("successfully Fund Withdrawned from "+obj.getAcc());
		
	}
	@GetMapping("/getAllTransactions/{acc}")
	public ResponseEntity<?> getTransactions(@PathVariable int acc ) {
		List<AccountTransaction> accountTransactions = accountService.viewTransactions(acc);
		return ResponseEntity.status(201).body("Total Transaction done by "+accountTransactions.toString());
		
	}	

}
