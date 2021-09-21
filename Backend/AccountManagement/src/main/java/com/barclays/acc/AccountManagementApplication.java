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
        //SpringApplication.run(AccountManagementApplication.class, args);
        ApplicationContext applicationContext=SpringApplication.run(AccountManagementApplication.class, args);
        ManagerServiceImpl employeeService=applicationContext.getBean(ManagerServiceImpl.class);
        employeeService.generateCustomerId();
    }


}
