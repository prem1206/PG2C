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
	private String panno;
	private String aadharno;
	private String customername;
	private String address;
	private String email;
	private String dateofbirth;
	private int passwordstatus;
	private int userid;
}
