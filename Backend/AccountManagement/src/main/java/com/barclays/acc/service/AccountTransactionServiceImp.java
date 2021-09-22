package com.barclays.acc.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.acc.model.AccountTransaction;
import com.barclays.acc.repository.AccountTransactionRepository;

@Service
public class AccountTransactionServiceImp implements AccountTransactionService {
	
	@Autowired
	AccountTransactionRepository accountTransactionRepository;
	
	@Override
	public void addTransaction(int acc1, int acc2, LocalDate transaction_date,String type, float amount) {
		AccountTransaction accountTransaction = AccountTransaction.builder()
				.transactoraccountno(acc1)
				.transacteeaccountno(acc2)
				.trn(123254)									//make Trn unique
				.transactiondate(transaction_date)
				.transactiontype(type)
				.amount(amount)
				.build();
		accountTransactionRepository.save(accountTransaction);
		
	}
	@Override
	public void viewTransaction(int acc) {
		System.out.println(accountTransactionRepository.findAllTransaction(acc).toString());
		
	}

}
