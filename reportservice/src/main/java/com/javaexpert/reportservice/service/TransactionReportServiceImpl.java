package com.javaexpert.reportservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.javaexpert.reportservice.model.Account;
import com.javaexpert.reportservice.model.FundTransfer;
import com.javaexpert.reportservice.model.TransactionDetails;

@Service
public class TransactionReportServiceImpl implements TransactionReportService {

	@Autowired
	RestTemplateBuilder restTemplateBuilder;			//To call Account and FundTransfer services
	
	@Override
	public TransactionDetails getTransactionDetails(String accountNumber) {
		
		TransactionDetails txnDteails = new TransactionDetails();		//To store Account and FundTransfer service responses. We'll return this txnDetails object eventually to client.(Since it has aggregated responses of both services.)
		
		Account accountResponse = restTemplateBuilder.build().getForObject("http://localhost:5051/banking/account/getSpecificAccount/" +accountNumber , Account.class);			//Getting Account object for specific account number.
		
		List<FundTransfer> fundTrasnferResponse = restTemplateBuilder.build().getForObject("http://localhost:5052/banking/fundTransfer/getTxnForAccount/" +accountNumber, List.class);	//Getting list of fundTransfers for specific account number.
		
		
		//Aggregating response to txnDetails object.
		txnDteails.setAccount(accountResponse);
		txnDteails.setFundTransfer(fundTrasnferResponse);
		
		return txnDteails;			//returning Aggregated object
	}
	
}
