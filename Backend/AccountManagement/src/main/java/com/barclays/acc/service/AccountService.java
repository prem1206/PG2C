package com.barclays.acc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barclays.acc.model.AccountTransaction;

@Service
public interface AccountService {
	
	public void fundTransfer(int a1,int a2,int amount); //POST
	public int checkBalance(int accountno);				//GET
	public void addMoney(int accountno,int amount);		//POST
	public void withdrawMoney(int accountno,int amount);//POST	
	public List<AccountTransaction> viewTransactions(int acc);				//GET
	public void exportTransactions();					
	
}
