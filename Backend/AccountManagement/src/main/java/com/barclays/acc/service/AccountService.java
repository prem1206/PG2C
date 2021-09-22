package com.barclays.acc.service;

import org.springframework.stereotype.Service;

@Service
public interface AccountService {
	
	public void fundTransfer(int a1,int a2,int amount);
	public int checkBalance(int accountno);
	public void addMoney(int accountno,int amount);
	public void withdrawMoney(int accountno,int amount);
	public void viewTransactions(int acc);
	public void exportTransactions();
	
}
