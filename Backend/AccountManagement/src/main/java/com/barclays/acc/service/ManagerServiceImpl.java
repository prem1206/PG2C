package com.barclays.acc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.barclays.acc.model.Account;
import com.barclays.acc.model.Customer;
import com.barclays.acc.model.Manager;
import com.barclays.acc.model.Users;
import com.barclays.acc.repository.AccountRepository;
import com.barclays.acc.repository.CustomerRepository;
import com.barclays.acc.repository.ManagerRepository;
import com.barclays.acc.repository.UsersRepository;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired 
	UsersRepository userRepository;

	@Override
	public int createNewAccount(Customer customer) {
		int custid = checkPanCard(customer.getPanno());
		if(custid == -1) {
			Users user=new Users();
			user.setPassword(generatePassword());
			user.setRoleid(0);
			userRepository.save(user);
			int userid = user.getUserid();
			System.out.println(userid);
			custid = generateCustomerId();
			customer.setCustomerid(custid);
			customer.setPasswordstatus(0);
			customer.setUserid(userid);
			customerRepository.save(customer);
			MailServiceImpl.sendMail(customer.getEmail(), "Password reset", "Thanks for creating a new account with us."
					+ "Your username is " + user.getUserid() 
					+ " . Your temporary password is "
					+ user.getPassword() + ". Click on ... to change your password. ");
		}
		int newAccNo = generateAccountNumber();
		Account acc = new Account(newAccNo, 0, custid);
		accountRepository.save(acc);
		MailServiceImpl.sendMail(customer.getEmail(), "Hello there!", "Thanks for creating a new account with us. "
				+ "Your account number is " + acc.getAccountno());
		return custid;
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
		int len = 9;
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return Integer.parseInt("0"+sb.toString());
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
	public int checkPanCard(String panNo) {
		List<Customer> listCustomers = customerRepository.findByPanno(panNo);
//		System.out.println(listCustomers);
		if(listCustomers.size() == 0) {
			return -1;
		}
		return listCustomers.get(0).getCustomerid();
	}


}
