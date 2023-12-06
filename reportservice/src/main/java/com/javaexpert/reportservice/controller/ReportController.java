package com.javaexpert.reportservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpert.reportservice.model.TransactionDetails;
import com.javaexpert.reportservice.service.TransactionReportService;
import com.javaexpert.reportservice.service.TransactionReportServiceImpl;

@RestController
@RequestMapping("/banking/report")
public class ReportController {
	
	@Autowired
	TransactionReportService txnReportService;
	
	@GetMapping("getTxnDetails/{accountNumber}")
	public TransactionDetails getTransactionDetails(@PathVariable String accountNumber){
		return txnReportService.getTransactionDetails(accountNumber);				//Returning aggregated response
	}
}
