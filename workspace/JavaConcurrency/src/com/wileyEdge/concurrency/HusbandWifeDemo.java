package com.wileyEdge.concurrency;

class JointAccount {
	public int balance = 100;

	public void withdraw(int amount) {
		balance -= amount;
	}
}

class Job implements Runnable {
	private JointAccount acct;

	public Job(JointAccount acct) {
		this.acct = acct;
	}

	private  void startWithdrawProcess(int amount) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " has entered inside method startWithdrawProcess");
		System.out.println(name + " is checking the balance");
		synchronized(this){
		if (amount <= acct.balance) {
			System.out.println(name + " has checked the balance which is sufficient");
			System.out.println(name + " is actually withdrawing");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			acct.withdraw(amount);
			System.out.println(name + " has withdrawn");
		}else {
			System.out.println(name + " has checked, the balance is not enough");
		}
		}
	}

	@Override
	public void run() {
		startWithdrawProcess(75);
		if (acct.balance < 0) {
			System.out.println("BIG PROBLEM");
		}
	}

}

public class HusbandWifeDemo {

	public static void main(String[] args) {
		JointAccount acct = new JointAccount();
		Job job = new Job(acct);
		Thread t1 = new Thread(job);
		Thread t2 = new Thread(job);
		t1.setName("Raj");
		t2.setName("Priya");
		t2.start();
		t1.start();
	}

}
