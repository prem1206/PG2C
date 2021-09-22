package com.barclays.acc.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="transactions")
@Entity
public class AccountTransaction {
	@Id
//	@SequenceGenerator(name = "transactionID",schema = "transactionID",initialValue = 1)
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionid;
	private int transactoraccountno;
	private int transacteeaccountno;
//	@SequenceGenerator(name = "trasactionID",schema = "transactionID",initialValue = 1,allocationSize = 1)
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int trn;
	private LocalDateTime transactiondate;
	private String transactiontype;
	private float amount;
	
}
