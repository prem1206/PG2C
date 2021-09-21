package com.barclays.acc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.acc.model.Account;
import com.barclays.acc.model.Customer;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
//	@Query("START TRANSACTION "
//			+ "UPDATE Account SET balance = balance - :amount  WHERE account_no= :account1"
//			+ "UPDATE Account SET balance = balance + 100 WHERE account_no=:account2"
//			+ "COMMIT")
//    public void transaction(@Param("account1")int account1,@Param("account2")int account2,
//    		@Param("amount")int amount);
	
}