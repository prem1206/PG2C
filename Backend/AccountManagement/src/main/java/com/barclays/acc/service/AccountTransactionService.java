package com.barclays.acc.service;

import java.time.LocalDate;
import java.util.List;

import com.barclays.acc.model.AccountTransaction;


public interface AccountTransactionService {
	public void addTransaction(int acc1,int acc2,LocalDate transaction_date ,String type,float amount);
	public List<AccountTransaction> viewTransaction(int acc);

}
