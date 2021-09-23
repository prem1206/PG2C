package com.barclays.acc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.barclays.acc.model.AccountTransaction;


public interface AccountTransactionService {
	public void addTransaction(int acc1,int acc2,LocalDateTime transaction_date ,String type,float amount);
	public List<AccountTransaction> viewTransaction(int acc);
	public List<AccountTransaction> viewAllTransaction(int acc);
	public List<AccountTransaction> exportTransaction(int acc, LocalDate startdate, LocalDate enddate);
	public int totalAmountWithdrawned(int acc,LocalDate date);
}
