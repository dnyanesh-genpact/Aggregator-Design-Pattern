package com.javaexpert.fundTransfer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FUND_TRANSFER")
public class FundTransfer {
	@Id
	private String transactionId;
	private String accountFrom;
	private String accountTo;
	private double amount;
	private String beneficiaryName;
	private String modeOfTransfer;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}
	public String getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(String accountTo) {
		this.accountTo = accountTo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getModeOfTransfer() {
		return modeOfTransfer;
	}
	public void setModeOfTransfer(String modeOfTransfer) {
		this.modeOfTransfer = modeOfTransfer;
	}
	@Override
	public String toString() {
		return "FundTransfer [transactionId=" + transactionId + ", accountFrom=" + accountFrom + ", accountTo="
				+ accountTo + ", amount=" + amount + ", beneficiaryName=" + beneficiaryName + ", modeOfTransfer="
				+ modeOfTransfer + "]";
	}
	
	
	
	
}
