package com.barclays.acc.model;

public class Account {

	private String accountnumber;
	private int balance;
	@Override
	public String toString() {
		return "Account [accountnumber=" + accountnumber + ", balance=" + balance + "]";
	}
	public Account(String accountnumber, int balance) {
		super();
		this.accountnumber = accountnumber;
		this.balance = balance;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
