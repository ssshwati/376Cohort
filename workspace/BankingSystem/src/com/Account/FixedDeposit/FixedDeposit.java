package com.Account.FixedDeposit;

import java.util.Scanner;

import com.Account.Account;

public class FixedDeposit extends Account {

	private int depositAmount = 0;
	private int tenure;
	// private double interestEarned;

	public FixedDeposit(long accountNumber, long bsbCode, String bankName, double balance, String openingDate) {
		super(accountNumber, bsbCode, bankName, balance, openingDate);
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("Enter deposit amount : (minimum 1000$) ");
			this.depositAmount = scanner.nextInt();
		} while (this.depositAmount < 1000);

		do{
			System.out.print("Enter tenure (min 1 yr max 7 yrs )");
			this.tenure = scanner.nextInt();
		}while(this.tenure < 1 || this.tenure > 7);
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public double calculateInterest() {
		interestEarned = 0.08 * depositAmount * tenure;
		return interestEarned;
	}

	public void displayFixedDepositAccountDetails(){
		System.out.println( "Account TYpe : Fixed Deposit \n" + "\ndepositAmount  : " + depositAmount + "\ntenure : " + tenure);
	}

}
