package com.barclays.acc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.barclays.acc.model.Account;
import com.barclays.acc.model.AccountTransaction;
import com.barclays.acc.repository.AccountRepository;
@Service
public class AccountServiceImp implements AccountService{

	@Autowired
	AccountTransactionService accountTransactionService;

	@Autowired
	AccountRepository accountrepository;
	
	
	@Override
	@Transactional
	@Modifying
	public void fundTransfer(int a1,int a2, int amount) throws ArithmeticException {
		Account acc1 =  accountrepository.findById(a1).get();
		Account acc2 =  accountrepository.findById(a2).get();
		if(acc1.getBalance() > amount) {
		acc1.setBalance(acc1.getBalance()-amount);
		acc2.setBalance(acc2.getBalance()+amount);
		accountrepository.save(acc1);
		accountrepository.save(acc2);
		System.out.print("Successfully made transaction");
		accountTransactionService.addTransaction(a1, a2,LocalDateTime.now(), "debit", (float)amount);
		}
		else
		{
			throw new ArithmeticException();
		}
	}

	@Override
	public int checkBalance(int accountno)throws NullPointerException {
		Account acc =  accountrepository.findById(accountno).get();
		return acc.getBalance();
	}

	@Override
	@Transactional
	@Modifying
	public void addMoney(int accountno,int amount) {
		Account acc = accountrepository.findById(accountno).get();
		acc.setBalance(acc.getBalance()+amount);
		accountrepository.save(acc);
		accountTransactionService.addTransaction(accountno, accountno,LocalDateTime.now(), "credit", (float)amount);
		
	}

	@Override
	@Transactional
	@Modifying
	public void withdrawMoney(int accountno,int amount) throws ArithmeticException{
		Account acc = accountrepository.findById(accountno).get();
		
			if(acc.getBalance() > amount) {
			acc.setBalance(acc.getBalance() - amount);
			accountrepository.save(acc);
			accountTransactionService.addTransaction(accountno, accountno,LocalDateTime.now(), "debit", (float)amount);
			}
			else {
				throw new ArithmeticException();
			
		} 
	}

	@Override
	public List<AccountTransaction> viewTransactions(int acc) {
	 List<AccountTransaction> accountTransactions = accountTransactionService.viewTransaction(acc);
	return accountTransactions;
		
	}

	@Override
	public List<AccountTransaction> exportTransactions(int acc,LocalDate startdate,LocalDate enddate) {
		
		 List<AccountTransaction> accountTransactions = accountTransactionService.exportTransaction(acc,startdate,enddate);
		 return accountTransactions;
	}

}

