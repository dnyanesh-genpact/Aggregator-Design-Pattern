package com.javaexpert.fundTransfer.model;

public class CrossRate {
	private String fromCurrency;
	private String toCurrency;
	private double crossRate;

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public double getCrossRate() {
		return crossRate;
	}

	public void setCrossRate(double crossRate) {
		this.crossRate = crossRate;
	}

	public CrossRate(String fromCurrency, String toCurrency, double crossRate) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.crossRate = crossRate;
	}

}
