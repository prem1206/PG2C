package com.barclays.acc.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.barclays.acc.model.Customer;
import com.barclays.acc.repository.AccountRepository;

@ExtendWith(MockitoExtension.class)
class ManagerServiceTest {

	@InjectMocks
	ManagerServiceImpl ms;
	
	@Test
	void testGeneratePassword() {
		String pass = ms.generatePassword();
		assertTrue(pass.length() == 8);
	}

	@Test
	void testGenerateAccountNumber() {
		int acc = ms.generateAccountNumber();
		assertTrue(acc >= 0);
	}

	@Test
	void testGenerateCustomerId() {
		int cust = ms.generateCustomerId();
		assertTrue(cust >= 0);
	}



}
