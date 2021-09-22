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
	public void changePassword( int userid, String password) {
		Users user = userRepository.findById(userid).get();
		String newpassword = "neel";
		if(password.equals(user.getPassword())){
			user.setPassword(newpassword);
			userRepository.save(user);
			System.out.println("Password changed successfully");
		}
		
	}
	
	@Override
	public void login(int userid, String password, int roleid) {
		Users user = userRepository.findById(userid).get();
		if(user == null) {
			System.out.println("Not a user");
		}
		else if(password.equals(user.getPassword()) && roleid == user.getRoleid()){
			System.out.println("Login successful");
		}
		else {
			System.out.println("Incorrect credentials");
		}
	};
}
