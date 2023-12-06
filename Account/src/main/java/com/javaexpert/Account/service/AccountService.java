package com.javaexpert.Account.service;

import java.util.List;

import com.javaexpert.Account.model.Account;


public interface AccountService {
	public Account createAccount(Account account);

	public List<Account> getBankAccounts();
	
	public Account getSingleAccount(String accountNumber);
	
}
