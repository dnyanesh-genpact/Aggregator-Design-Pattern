package com.javaexpert.Account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpert.Account.model.Account;
import com.javaexpert.Account.repository.AccountRepo;


@Service
public class AccountServiceImpl implements AccountService{

	@Autowired AccountRepo accountRepository;
	
	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
		 
	}

	@Override
	public List<Account> getBankAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account getSingleAccount(String accountNumber) {
		return accountRepository.findById(accountNumber).get();		//To avoid getting nullPointerException since we've not put NotNull validation for accNum and so it may have null value as well.
	}
	
}
