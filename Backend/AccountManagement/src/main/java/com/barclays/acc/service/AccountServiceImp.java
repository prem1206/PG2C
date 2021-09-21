package com.barclays.acc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.barclays.acc.model.Account;
import com.barclays.acc.repository.AccountRepository;
@Service
public class AccountServiceImp implements AccountService{
	
	@Autowired
	AccountRepository accountrepository;

	@Override
	@Transactional
	@Modifying
	public void fundTransfer(int a1,int a2, int amount) {
		Account acc1 =  accountrepository.findById(a1).get();
		Account acc2 =  accountrepository.findById(a2).get();
		acc1.setBalance(acc1.getBalance()-amount);
		acc2.setBalance(acc2.getBalance()+amount);
		accountrepository.save(acc1);
		accountrepository.save(acc2);
		System.out.print("Successfully made transaction");
	}

	@Override
	public int checkBalance(int accountno)throws NullPointerException {
		Account acc =  accountrepository.findById(1234).get();
		System.out.println(acc.getBalance());
		return 0;
	}

	@Override
	@Transactional
	@Modifying
	public void addMoney(int accountno,int amount) {
		Account acc = accountrepository.findById(accountno).get();
		acc.setBalance(acc.getBalance()+amount);
		accountrepository.save(acc);
		
	}

	@Override
	@Transactional
	@Modifying
	public void withdrawMoney(int accountno,int amount) {
		Account acc = accountrepository.findById(accountno).get();
		acc.setBalance(acc.getBalance() - amount);
		accountrepository.save(acc);
		
	}

	@Override
	public void viewTransactions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exportTransactions() {
		// TODO Auto-generated method stub
		
	}

}
