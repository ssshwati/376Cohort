package com.Account.SavingAccount;

import java.util.Scanner;

import com.Account.Account;
import com.Exp.InsufficientBalanceException;
import com.Exp.InsufficientInitialBalanceException;

public class SavingAccount extends Account {

	private boolean isSalaryAccount;
	private int minimumBalance = 100;

	public SavingAccount(long accountNumber, long bsbCode, String bankName, double balance, String openingDate,boolean isSalaryAccount,int minimumBalance) {
		super(accountNumber, bsbCode, bankName, balance, openingDate);
		this.isSalaryAccount = isSalaryAccount;
		this.minimumBalance = minimumBalance;
	}

	public double getBalance() {
		return balance;
	}

	public boolean isSalaryAccount() {
		return isSalaryAccount;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double checkBalance() {
		return getBalance();
	}

	public void deposit(double amount) {
		setBalance(getBalance() + amount);
	}

	public void withdraw(double amount) throws InsufficientBalanceException {
        if (isSalaryAccount) {
            // If Salary Account, only zero balance allowed
            if (amount > 0) {
                throw new InsufficientBalanceException("Cannot withdraw from Salary Account. Balance should remain zero.");
            }
        } else {
            // If Non-Salary Account, check minimum balance and allow excess withdrawal
            if (getBalance() - amount < minimumBalance) {
                throw new InsufficientBalanceException("Insufficient balance for Savings Account, Minimum balance should be " + minimumBalance + " $");
            }
            setBalance(getBalance() - amount);
        }
    }

	@Override
	public double calculateInterest() {
		interestEarned = 0.04 * getBalance();
		return interestEarned;
	}

	public void displaySavingsAccountDetails() {
		System.out.println("Account TYpe : Savings \n" + "\nisSalaryAccount  : " + isSalaryAccount
				+ "\nminimumBalance : " + minimumBalance);
	}

}
