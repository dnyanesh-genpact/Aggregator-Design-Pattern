package com.javaexpert.fundTransfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpert.fundTransfer.model.FundTransfer;
import com.javaexpert.fundTransfer.service.FundTransferService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/banking/fundTransfer")
public class FundTransferController {	
	
	@Autowired 
	FundTransferService fundTransferServ;
	
	@PostMapping("/newFundTransferRequest")
	@CircuitBreaker(name = "bank-rates-service", fallbackMethod = "processTxnWithDefaultRate")
	public FundTransfer processTransaction(@RequestBody FundTransfer fundDetails) {
		return fundTransferServ.processTransaction(fundDetails);
	}
	
	//Fallback Method
	public FundTransfer processTxnWithDefaultRate(FundTransfer fundDetails, Exception e) {
		return fundTransferServ.processTxnWithDefaultRate(fundDetails);				//Calling implementation of fallback method.
	}
	
	@GetMapping("/getTransactions")
	public List<FundTransfer> getTransactions(){
		return fundTransferServ.getTransactions();
	}
	
	@GetMapping("/getTxnForAccount/{accountNumber}")
	public List<FundTransfer> getTransactionsForAccount(@PathVariable String accountNumber) {
		return fundTransferServ.getTransactionsForAccount(accountNumber);
	}
}
