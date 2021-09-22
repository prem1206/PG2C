package com.barclays.acc.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.barclays.acc.model.AccountTransaction;
import com.barclays.acc.service.AccountService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@RestController
public class AccountController {
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	static class FundObj{
	 int acc1,acc2,amount;	
	}
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	static class moneyObj{
		int acc,amount;
	}
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	static class trancObj{
		int acc;
		String startdate;
		String enddate;
		
	}
	
	@Autowired
	private  AccountService accountService;
	
	@GetMapping("/")
	public String test() {
		return "Hello World";
	}
	@PostMapping("/fundtransfer")
	public ResponseEntity<?> fundTransfer(@RequestBody FundObj obj ) {
		
		try {
			accountService.fundTransfer(obj.getAcc1(), obj.getAcc2(), obj.getAmount());
			return ResponseEntity.status(201).body("successfully Fund Tranfered");
			}
			catch (Exception e) {
				return ResponseEntity.status(201).body("Insufficient Balance");
			}
		
	}	
	@GetMapping("/checkbalance/{acc}")
	public ResponseEntity<?> checkbalance(@PathVariable int acc ) {
		int balance = accountService.checkBalance(acc);
		return ResponseEntity.status(201).body("Balance in Account "+acc+" is "+balance);
		
	}	
	@PostMapping("/addmoney")
	public ResponseEntity<?> addMoney(@RequestBody moneyObj obj ) {
		accountService.addMoney(obj.getAcc(), obj.getAmount());
		return ResponseEntity.status(201).body("successfully Fund added to "+obj.getAcc());
		
	}
	@PostMapping("/withdraw")
	public ResponseEntity<?> withDraw(@RequestBody moneyObj obj ) {
		try {
		accountService.withdrawMoney(obj.getAcc(), obj.getAmount());
		return ResponseEntity.status(201).body("successfully Fund Withdrawned from "+obj.getAcc());

		}
		catch (Exception e) {
			return ResponseEntity.status(201).body("Insufficient Balance");
		}
	}
	@GetMapping("/getAllTransactions/{acc}")
	public ResponseEntity<?> getTransactions(@PathVariable int acc ) {
		List<AccountTransaction> accountTransactions = accountService.viewTransactions(acc);
		return ResponseEntity.status(201).body("Total Transaction done by "+accountTransactions.toString());
		
	}	
	@PostMapping("/gettransaction")
	public ResponseEntity<?> getTransactionbetween(HttpServletResponse response,@RequestBody trancObj obj  )throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String startdate = LocalDate.parse(obj.getStartdate(), formatter).format(formatter2);
		String enddate = LocalDate.parse(obj.getEnddate(), formatter).format(formatter2);
		
		List<AccountTransaction> accountTransactions = accountService.exportTransactions(obj.getAcc(),LocalDate.parse(startdate),LocalDate.parse(enddate));
		
		 response.setContentType("text/csv");     
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=" + obj.getAcc() + ".csv";
	        response.setHeader(headerKey, headerValue);
	         
	 
	        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
	        String[] csvHeader = {"Transaction ID", "Sender", "Receiver", "Transaction Reference number", "Date","Type","Amount"};
	        String[] nameMapping = {"transactionid", "transactoraccountno", "transacteeaccountno","trn","transactiondate","transactiontype","amount"};
	         
	        csvWriter.writeHeader(csvHeader);
	         
	        for (AccountTransaction accountTransaction : accountTransactions) {
	            csvWriter.write(accountTransaction, nameMapping);
	        }
	         
	        csvWriter.close();
	         
		return ResponseEntity.status(201).body("Total Transaction done by "+accountTransactions.toString());
		
	}	

}
