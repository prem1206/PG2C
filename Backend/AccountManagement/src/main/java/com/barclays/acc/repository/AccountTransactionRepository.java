package com.barclays.acc.repository;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.barclays.acc.model.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {

	@Query("select t from AccountTransaction t where t.transacteeaccountno=:account or t.transactoraccountno=:account")
			List<AccountTransaction> findAllTransaction(@Param("account") int account);
	@Query(
			value = "SELECT * FROM transactions where transactoraccountno=:account or transacteeaccountno=:account order by transactiondate DESC LIMIT 5",
			nativeQuery = true
			)
	List<AccountTransaction> findTopFiveTransaction(@Param("account") int account);
	
	@Query(
			value="select * from transactions"
					+" where (transactoraccountno=:account or transacteeaccountno=:account)"
					+" and (date(transactiondate) between :startdate and :enddate)"
					+ "order by transactiondate",
					nativeQuery = true
			)
	List<AccountTransaction> findTransactionBetweenDate(@Param("account") int account,@Param("startdate") LocalDate startdate,@Param("enddate") LocalDate enddate);
	

}

