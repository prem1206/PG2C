package com.barclays.acc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.acc.model.Customer;

@Repository
public interface AccountRepository extends JpaRepository<Customer, Integer> {

	
	
}