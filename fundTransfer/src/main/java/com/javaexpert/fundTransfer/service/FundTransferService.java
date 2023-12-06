package com.javaexpert.fundTransfer.service;

import java.util.List;

import com.javaexpert.fundTransfer.model.FundTransfer;

public interface FundTransferService {
	public FundTransfer processTransaction(FundTransfer fundTransfer);
	public FundTransfer processTxnWithDefaultRate(FundTransfer fundTransfer);	//Fallback Method
	public List<FundTransfer> getTransactions();
	public List<FundTransfer> getTransactionsForAccount(String accountFrom);
}
