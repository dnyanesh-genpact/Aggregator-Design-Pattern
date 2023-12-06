package com.javaexpert.Account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpert.Account.model.Account;
import com.javaexpert.Account.service.AccountService;


@RestController
@RequestMapping("/banking/account")
public class AccountController {
	
	@Autowired AccountService accService;
	
	@PostMapping("/createAccount")
	public Account createAccount(@RequestBody Account acc) {
		return accService.createAccount(acc);
	}
	
	@GetMapping("/getBankAccounts")
	public List<Account> getBankAccounts() {
		return accService.getBankAccounts();
	}
	
	@GetMapping("/getSpecificAccount/{accountNumber}")
	public Account getOneAccount(@PathVariable String accountNumber) {
		return accService.getSingleAccount(accountNumber);
	}
	
}
