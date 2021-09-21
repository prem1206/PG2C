package com.barclays.acc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.barclays.acc.model.Users;
import com.barclays.acc.repository.UsersRepository;

public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersRepository userRepository;
	
	@Override
	public void changePassword( int userid, String password) {
		Users user = userRepository.findById(userid).get();
		user.setPassword(password);
		userRepository.save(user);
		System.out.println("Password changed successfully");
	}
}
