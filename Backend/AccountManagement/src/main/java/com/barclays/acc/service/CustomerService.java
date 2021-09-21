package com.barclays.acc.service;

import java.util.List;

import com.barclays.acc.model.Account;

public interface CustomerService {
	
	public List<Account> viewAccounts(int customerID);
	
//	add in account
//	public String viewTransactions(int start, int end);

}
