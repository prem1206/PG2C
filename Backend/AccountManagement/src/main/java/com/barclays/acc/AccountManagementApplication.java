package com.barclays.acc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.barclays.acc.service.ManagerService;
import com.barclays.acc.service.ManagerServiceImpl;

@SpringBootApplication
public class AccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountManagementApplication.class, args);
//		ApplicationContext applicationContext=SpringApplication.run(ManagerService.class, args);
//		ManagerService employeeService=applicationContext.getBean(ManagerService.class);
//		employeeService.display();
	}
	
	@Bean(initMethod="display")
    public ManagerServiceImpl getFunnyBean() {
        return new ManagerServiceImpl();
    }

}
