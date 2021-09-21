package com.barclays.acc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.barclays.acc.model.Account;
import com.barclays.acc.model.Customer;
import com.barclays.acc.model.Manager;
import com.barclays.acc.repository.AccountRepository;
import com.barclays.acc.repository.CustomerRepository;
import com.barclays.acc.repository.ManagerRepository;
import java.util.Random;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public void createNewAccount(String pan_no, String pancard, String aadharcard, String address, String email, String dob) {
		int custid = checkPanCard(pan_no);
		if(custid == -1) {
			custid = generateCustomerId();
			Customer cust = new Customer(custid, pancard, aadharcard, address, email, dob, 0);
			customerRepository.save(cust);
		}
		int newAccNo = generateAccountNumber();
		Account acc = new Account(newAccNo, 0, custid);
		accountRepository.save(acc);
		
//		send password reset mail + welcome
	}

	@Override
	public String generatePassword() {
		int len = 8;
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
		          +"jklmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	@Override
	public int generateAccountNumber() {
		int len = 10;
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return Integer.parseInt(sb.toString());
	}

	@Override
	public int generateCustomerId() {
		int len = 6;
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return Integer.parseInt(sb.toString());
	}

	@Override
	public int checkPanCard(String pan_no) {
		List<Customer> listCustomers = customerRepository.findByPancard(pan_no);
		if(listCustomers == null) {
			return -1;
		}
		return listCustomers.get(0).getCustomerID();
	}

	@Override
	public void sendMail(String password, String email) {
		System.out.println("Mail sent");
	}
	

}
