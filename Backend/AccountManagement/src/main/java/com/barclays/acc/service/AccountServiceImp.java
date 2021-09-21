package com.barclays.acc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.acc.model.Account;
import com.barclays.acc.repository.AccountRepository;
@Service
public class AccountServiceImp implements AccountService{
	
	@Autowired
	AccountRepository accountrepository;

	@Override
	public void fundTransfer(int a1,int a2, int amount) {
		//accountrepository.transaction(1234, 1235, 100);
		Account acc1 =  accountrepository.findById(a1).get();
		Account acc2 =  accountrepository.findById(a2).get();
		acc1.setBalance(acc1.getBalance()-amount);
		acc2.setBalance(acc2.getBalance()+amount);
		accountrepository.save(acc1);
		accountrepository.save(acc2);
		System.out.print("Successfully made transaction");
	}

	@Override
	public int checkBalance(int accountno) {
		 accountrepository.findById(1234);
		return 0;
	}

	@Override
	public void addMoney() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawMoney() {
		// TODO Auto-generated method stub
		
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
