package com.barclays.acc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.barclays.acc.service.AccountService;
import com.barclays.acc.service.ManagerService;

@SpringBootApplication
public class AccountManagementApplication {


	public static void main(String[] args) {
		//SpringApplication.run(AccountManagementApplication.class, args);
		ApplicationContext applicationContext=SpringApplication.run(AccountManagementApplication.class, args);
		ManagerService employeeService=applicationContext.getBean(ManagerService.class);
		employeeService.generateCustomerId();

	}
	

}
