package com.barclays.acc.model;

public class Customer {
	private int customerID;
	private String pancard;
	private String adhaarcard;
	private String Address;
	private String email;
	private String DOB;
	private String active;
	public Customer(int customerID, String pancard, String adhaarcard, String address, String email, String dOB,
			String active) {
		super();
		this.customerID = customerID;
		this.pancard = pancard;
		this.adhaarcard = adhaarcard;
		Address = address;
		this.email = email;
		DOB = dOB;
		this.active = active;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getAdhaarcard() {
		return adhaarcard;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", pancard=" + pancard + ", adhaarcard=" + adhaarcard
				+ ", Address=" + Address + ", email=" + email + ", DOB=" + DOB + ", active=" + active + "]";
	}
	public void setAdhaarcard(String adhaarcard) {
		this.adhaarcard = adhaarcard;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
}
