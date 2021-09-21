package com.barclays.acc.service;

public interface ManagerService {
	public void createNewAccount(String pan_no, String pancard, String aadharcard, String address, String email, String dob);
	public String generatePassword();
	public int generateAccountNumber();
	public int generateCustomerId();
	public int checkPanCard(String pan_no);
	public void sendMail(String password, String email);
}
