package com.barclays.acc.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.acc.model.AccountTransaction;
import com.barclays.acc.repository.AccountTransactionRepository;

@Service
public class AccountTransactionServiceImp implements AccountTransactionService {
	
	@Autowired
	AccountTransactionRepository accountTransactionRepository;
	
	public static Logger logger = Logger.getLogger(AccountTransactionServiceImp.class);
	
	public int generateTrnNumber() {
		logger.debug("Generating TRN Number..");
		int len = 5;
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		logger.debug("Generated new TRN no "+sb);
		return Integer.parseInt("0"+sb.toString());
	}
	
	@Override
	public void addTransaction(int acc1, int acc2, LocalDateTime transaction_date,String type, float amount) {
		
		AccountTransaction accountTransaction = AccountTransaction.builder()
				.transactoraccountno(acc1)
				.transacteeaccountno(acc2)
				.trn(generateTrnNumber())									//make Trn unique
				.transactiondate(transaction_date)
				.transactiontype(type)
				.amount(amount)
				.build();
		accountTransactionRepository.save(accountTransaction);
		logger.info("Transaction with trn "+accountTransaction.getTrn()+" added successfully.");
		
	}
	@Override //For Top 5 Transaction
	public List<AccountTransaction> viewTransaction(int acc) {
		logger.info("Retrieving recent transactions from the user account "+acc);
		List<AccountTransaction> accountTransactions = accountTransactionRepository.findTopFiveTransaction(acc);
		return accountTransactions;
		
	}
	@Override
	public List<AccountTransaction> viewAllTransaction(int acc) {
		logger.info("Retrieving All transactions from the user account "+acc);
		List<AccountTransaction> accountTransactions = accountTransactionRepository.findAllTransaction(acc);
		return accountTransactions;
		
	}
	
	@Override
	public List<AccountTransaction> exportTransaction(int acc,LocalDate startdate,LocalDate enddate) {
		logger.info("Exporting transactions for the user account "+acc+" from "+startdate+" to "+enddate);
		List<AccountTransaction> accountTransactions = accountTransactionRepository.findTransactionBetweenDate(acc,startdate,enddate);
		return accountTransactions;
		
	}

}
