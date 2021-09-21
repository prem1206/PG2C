package com.barclays.acc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.barclays.acc.model.Manager;
import com.barclays.acc.repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Override
	public void display()
	{
		String p = managerRepository.findAll().toString();
		System.out.println(p);
	}
}
