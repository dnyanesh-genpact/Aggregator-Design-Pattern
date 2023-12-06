package com.javaexpert.fundTransfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaexpert.fundTransfer.model.CrossRate;
import com.javaexpert.fundTransfer.model.FundTransfer;
import com.javaexpert.fundTransfer.repository.FundTransferRepo;

@Service
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	FundTransferRepo fundTransferRepository;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	@Override
	public FundTransfer processTransaction(FundTransfer fundTransfer) {

		CrossRate crossRate = new CrossRate("INR", "USD", 0);

		//Chain of Responsibility - fundTransfer service is calling CrossRates service here to get the rates first and then process fund transfer with rates.
		ResponseEntity<CrossRate> responseEntity = restTemplateBuilder.build().exchange(
				"http://localhost:5056/banking/rates/crossRate", HttpMethod.POST, new HttpEntity<CrossRate>(crossRate),
				CrossRate.class);

		crossRate = responseEntity.getBody();
		
		fundTransfer.setAmount(fundTransfer.getAmount() * crossRate.getCrossRate());
		
		return fundTransferRepository.save(fundTransfer);
	}
	
	
	//Fallback Method
	@Override
	public FundTransfer processTxnWithDefaultRate(FundTransfer fundTransfer) {

		CrossRate crossRate = new CrossRate("INR", "USD", 0);
		
		fundTransfer.setAmount(fundTransfer.getAmount() * crossRate.getCrossRate());
		
		return fundTransferRepository.save(fundTransfer);
	}

	@Override
	public List<FundTransfer> getTransactions() {
		return fundTransferRepository.findAll();
	}

	@Override
	public List<FundTransfer> getTransactionsForAccount(String accountNumber) {
		return fundTransferRepository.findByAccountFrom(accountNumber);
	}

}
