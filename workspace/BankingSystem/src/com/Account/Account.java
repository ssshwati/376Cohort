package com.Account;

import java.io.Serializable;

public abstract class Account implements Serializable{

	private long accountNumber;
	private long bsbCode;
	private String bankName;
	protected double balance;
	private String openingDate;
	protected double interestEarned;

	// Parametrized constructor for Account class
	public Account(long accountNumber, long bsbCode, String bankName, double balance, String openingDate) {
		this.accountNumber = accountNumber;
		this.bsbCode = bsbCode;
		this.bankName = bankName;
		this.balance = balance;
		this.openingDate = openingDate;
	}

	public abstract double calculateInterest();

	// Updated toString method
	@Override
	public String toString() {
		return "Account Number: " + accountNumber + "\nBSB Code: " + bsbCode + "\nBank Name: " + bankName
				+ "\nBalance: " + balance + "\nOpening Date: " + openingDate + "\n";
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double d) {
		balance+=d;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public long getBsbCode() {
		return bsbCode;
	}

	public String getBankName() {
		return bankName;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public double getInterestEarned() {
		return interestEarned;
	}


}
