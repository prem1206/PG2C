package com.barclays.acc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.acc.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public String viewAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	public String viewTransactions(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

}
