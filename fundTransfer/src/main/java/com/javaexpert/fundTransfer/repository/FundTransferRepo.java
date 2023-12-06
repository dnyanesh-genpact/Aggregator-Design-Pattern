package com.javaexpert.fundTransfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpert.fundTransfer.model.FundTransfer;

public interface FundTransferRepo extends JpaRepository<FundTransfer, String> {
	public List<FundTransfer> findByAccountFrom(String accountNumber);
}
