package com.barclays.acc.service;


public interface AccountService {
	
	public void fundTransfer(int a1,int a2,int amount);
	public int checkBalance(int accountno);
	public void addMoney();
	public void withdrawMoney();
	public void viewTransactions();
	public void exportTransactions();
	
}
