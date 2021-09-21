package com.barclays.acc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.acc.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public void fundTransfer() {
		
	}
	
	public int checkBalance() {
		return 1;
	}
	public void addMoney() {
		
	}
	public void withdrawMoney() {
		
	}
	public void viewTransactions(){
	
	}
	public void exportTransactions() {
		
	}
	
}
