package com.barclays.acc.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.barclays.acc.model.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {

	@Query("select t from AccountTransaction t where t.transacteeaccountno=:account or t.transactoraccountno=:account")
			Collection<AccountTransaction> findAllTransaction(@Param("account") int account);
}

