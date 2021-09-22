package com.barclays.acc.service;

import java.time.LocalDate;


public interface AccountTransactionService {
	public void addTransaction(int acc1,int acc2,LocalDate transaction_date ,String type,float amount);
	public void viewTransaction(int acc);

}
