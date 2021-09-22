package com.barclays.acc.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.acc.model.AccountTransaction;
import com.barclays.acc.repository.AccountTransactionRepository;

@Service
public class AccountTransactionServiceImp implements AccountTransactionService {
	
	@Autowired
	AccountTransactionRepository accountTransactionRepository;
	
	public int generateAccountNumber() {
		int len = 5;
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return Integer.parseInt("0"+sb.toString());
	}
	@Override
	public void addTransaction(int acc1, int acc2, LocalDateTime transaction_date,String type, float amount) {
		
		AccountTransaction accountTransaction = AccountTransaction.builder()
				.transactoraccountno(acc1)
				.transacteeaccountno(acc2)
				.trn(generateAccountNumber())									//make Trn unique
				.transactiondate(transaction_date)
				.transactiontype(type)
				.amount(amount)
				.build();
		accountTransactionRepository.save(accountTransaction);
		
	}
	@Override //For Top 5 Transaction
	public List<AccountTransaction> viewTransaction(int acc) {
		List<AccountTransaction> accountTransactions = accountTransactionRepository.findTopFiveTransaction(acc);
		return accountTransactions;
		
	}
	@Override
	public List<AccountTransaction> viewAllTransaction(int acc) {
		List<AccountTransaction> accountTransactions = accountTransactionRepository.findAllTransaction(acc);
		return accountTransactions;
		
	}
	
	@Override
	public List<AccountTransaction> exportTransaction(int acc,LocalDate startdate,LocalDate enddate) {
		List<AccountTransaction> accountTransactions = accountTransactionRepository.findTransactionBetweenDate(acc,startdate,enddate);
		return accountTransactions;
		
	}

}
