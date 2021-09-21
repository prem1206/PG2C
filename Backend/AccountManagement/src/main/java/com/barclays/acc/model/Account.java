package com.barclays.acc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="bank_accounts")
public class Account {
	@Id
	private int account_no;
	private int balance;
	private int customerid;
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public Account(int account_no, int balance, int customerid) {
		super();
		this.account_no = account_no;
		this.balance = balance;
		this.customerid = customerid;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

}
