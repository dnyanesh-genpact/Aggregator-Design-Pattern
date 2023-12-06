package com.javaexpert.Account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaexpert.Account.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, String>{
	
}
