package com.barclays.acc.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.barclays.acc.model.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {

	@Query("select t from AccountTransaction t where t.transactee_account_no=:account or t.transactor_account_no=:account")
			List<AccountTransaction> findAllTransaction(@Param("account") int account);
}

