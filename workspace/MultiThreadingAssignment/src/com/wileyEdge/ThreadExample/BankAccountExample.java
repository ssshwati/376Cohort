package com.wileyEdge.ThreadExample;

class BankAccount {
	private double balance;

	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}

	public synchronized void deposit(double amount) {
		balance += amount;
		System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ", New Balance: " + balance);
	}

	public synchronized void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			System.out
					.println(Thread.currentThread().getName() + " withdrawn: " + amount + ", New Balance: " + balance);
		} else {
			System.out.println(Thread.currentThread().getName() + " - Insufficient funds for withdrawal: " + amount);
		}
	}

	public synchronized double getBalance() {
		return balance;
	}
}

class TransactionThread implements Runnable {
	private BankAccount account;
	private boolean isDeposit;
	private double amount;

	public TransactionThread(BankAccount account, boolean isDeposit, double amount) {
		this.account = account;
		this.isDeposit = isDeposit;
		this.amount = amount;
	}

	@Override
	public void run() {
		if (isDeposit) {
			account.deposit(amount);
		} else {
			account.withdraw(amount);
		}
	}
}

public class BankAccountExample {

	public static void main(String[] args) {
		BankAccount account = new BankAccount(1000.0);

		Thread depositThread1 = new Thread(new TransactionThread(account, true, 200.0), "Thread-1");
		Thread depositThread2 = new Thread(new TransactionThread(account, true, 300.0), "Thread-2");
		Thread withdrawThread1 = new Thread(new TransactionThread(account, false, 150.0), "Thread-3");
		Thread withdrawThread2 = new Thread(new TransactionThread(account, false, 250.0), "Thread-4");
		depositThread1.start();
		depositThread2.start();
		withdrawThread1.start();
		withdrawThread2.start();

		try {
			depositThread1.join();
			depositThread2.join();
			withdrawThread1.join();
			withdrawThread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print the final balance after all transactions
		System.out.println("Final Balance: " + account.getBalance());
	}
}
