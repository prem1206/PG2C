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
	private int customerID;
	private String pancard;
	private String adhaarcard;
	private String Address;
	private String email;
	private String DOB;
	private int status;
}
