package com.barclays.acc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.acc.model.Users;
import com.barclays.acc.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersRepository userRepository;
	
	@Override
	public boolean changePassword( int userid, String password) {
		
		Users user;
		try 
		{ 
			user = userRepository.findById(userid).get();
		}
		catch(Exception e) 
		{
			user = null;
		}
		if(user == null) {
			System.out.println("Not a user");
			return false;
		}
		String newpassword = "123";
		
		if(password.equals(user.getPassword())){
			user.setPassword(newpassword);
			userRepository.save(user);
			System.out.println("Password changed successfully");
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
		}
		catch(Exception e) 
		{
			user = null;
		}
		if(user == null) {
			System.out.println("Not a user");
		}
		else if(user.getUserid()==userid && password.equals(user.getPassword()) && roleid == user.getRoleid()){
			System.out.println("Login successful");
			return true;
		}
		else {
			System.out.println("Incorrect credentials");
		}
		return false;
		
	};
	}
