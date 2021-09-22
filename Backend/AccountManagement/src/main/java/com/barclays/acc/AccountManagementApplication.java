package com.barclays.acc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.barclays.acc.service.AccountService;

@SpringBootApplication

public class AccountManagementApplication {


	public static void main(String[] args) {

		//SpringApplication.run(AccountManagementApplication.class, args);
		ApplicationContext applicationContext=SpringApplication.run(AccountManagementApplication.class, args);
		AccountService employeeService=applicationContext.getBean(AccountService.class);
		
	}
	

}
