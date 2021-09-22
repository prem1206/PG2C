package com.barclays.acc.service;

import com.barclays.acc.model.Customer;

public interface ManagerService {
	public int createNewAccount(Customer customer);
	public String generatePassword();
	public int generateAccountNumber();
	public int generateCustomerId();
	public int checkPanCard(String panNo);
}
