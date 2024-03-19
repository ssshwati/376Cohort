package com.Exp;

public class BankAccount {
	private int balance = 100;

	public void withDraw(int amount) throws InsufficientFundsException {
		if (amount < balance) {
			balance -= amount;
		}else {
			InsufficientFundsException ife = new InsufficientFundsException("not enough Balance");
			throw ife;
		}
	}
}
