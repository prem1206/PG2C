package com.barclays.acc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="customer_profiles")
public class Customer {
	@Id
	private int customerid;
	private String panNo;
	private String aadhar_no;
	private String customer_name;
	private String address;
	private String email;
	private String date_of_birth;
	private int password_status;
	private int userid;
}
