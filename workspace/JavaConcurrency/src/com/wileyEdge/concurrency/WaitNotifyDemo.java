package com.wileyEdge.concurrency;

class Account {
	public int balance;

	public void withdraw(int amount) {
		balance -= amount;
	}

	public void deposit(int amount) {
		balance += amount;
	}
}

class Depositor implements Runnable {
	private Account acct;

	public Depositor(Account acct) {
		this.acct = acct;
	}

	@Override
	public void run() {
		synchronized (acct) {
			acct.deposit(100);
			acct.notifyAll();
		}	
	}

}

class Withdrawer implements Runnable {
	private Account acct;

	public Withdrawer(Account acct) {
		this.acct = acct;
	}

	@Override
	public void run() {
		synchronized (acct) {
			try {
				acct.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			acct.withdraw(100);
		}
		if (acct.balance < 0) {
			System.out.println("BIG PROBLEM");
		}else {
			System.out.println("No PROBLEM");
		}
	}

}

public class WaitNotifyDemo {

	public static void main(String[] args) {
		Account acct = new Account();
		Depositor depo = new Depositor(acct);
		Withdrawer withdraw = new Withdrawer(acct);
		Thread t1 = new Thread(depo);
		t1.setName("Raj");
		Thread t2 = new Thread(withdraw);
		t2.setName("Priya");
		t2.start();
		t1.start();
	}

}
