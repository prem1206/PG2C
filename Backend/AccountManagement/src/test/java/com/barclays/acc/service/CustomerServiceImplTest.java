package com.barclays.acc.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.barclays.acc.model.Account;
import com.barclays.acc.repository.AccountRepository;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
	
	
	@InjectMocks
	CustomerServiceImpl cs;
	@Mock
	AccountRepository ar;
	
	@Test
	void test() {
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account(1234, 0, 487182));
		Mockito.when(cs.viewAccounts(487182)).thenReturn(accounts);
		List<Account> ret = cs.viewAccounts(487182);
		assertTrue(ret.size() > 0);
	}
	
	@Test
	void test1() {
		List<Account> accounts = new ArrayList<Account>();
		Mockito.when(cs.viewAccounts(487182)).thenReturn(null);
		List<Account> ret = cs.viewAccounts(487182);
		assertTrue(ret == null);
	}

}
