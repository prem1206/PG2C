package com.barclays.acc.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.acc.model.Customer;
import com.barclays.acc.model.Users;
import com.barclays.acc.repository.CustomerRepository;
import com.barclays.acc.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public static Logger logger = Logger.getLogger(UsersServiceImpl.class);
	
	@Override
	public boolean changePassword( int userid, String password, String newpassword) {
		
		Users user;
		try 
		{ 
			user = userRepository.findById(userid).get();
			logger.debug("Checking if user ID "+userid+" exists..");
		}
		catch(Exception e) 
		{
			user = null;
			logger.error("User ID "+userid+" not found.");
		}
		if(user == null) {
			return false;
		}
		Customer cus=customerRepository.findByUserid(userid).get(0);
		if(cus.getPasswordstatus()==1) {
			logger.error("Password for user "+userid+" has already been set");
			return false;
		}
		if(password.equals(user.getPassword())){
			user.setPassword(newpassword);
			userRepository.save(user);
			cus.setPasswordstatus(1);
			customerRepository.save(cus);
			logger.info("Password for "+userid+" changed successfully");
			return true;
		}
		return false;
		
	}
	
	@Override
	public boolean login(int userid, String password, int roleid) {
		
		Users user;
		
		try 
		{ 
			user = userRepository.findById(userid).get();
			logger.debug("Checking if user ID "+userid+" exists..");
		}
		catch(Exception e) 
		{
			user = null;
			logger.error("User ID "+userid+" not found.");
		}
		if(user == null) {
			return false;
		}
		else if(user.getUserid()==userid && password.equals(user.getPassword()) && roleid == user.getRoleid()){
			logger.info("Login for user "+userid+" successful");
			return true;
		}
		else {
			logger.error("Incorrect credentials by "+userid);
		}
		return false;
		
	};
	}
