package com.wileyEdge.concurrency;

class Job1 extends Thread {
	@Override
	public void run() {
		method2();
	}

	public void method2() {
		String name  = Thread.currentThread().getName();
		for (int j = 1000; j <= 2000; j++) {
			System.out.println(name + " j = " + j);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Job2 implements Runnable {
	public void method1() {
		String name  = Thread.currentThread().getName();
		for (int i = 0; i <= 1000; i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " i = " + i);
		}
	}

	@Override
	public void run() {
		method1();
	}

}

public class ConcurrencyDemo {

	public static void main(String[] args) {
//		ConcurrencyDemo demo = new ConcurrencyDemo();
		Job1 job1 = new Job1();
		Thread t1 = new Thread(job1);
		Job2 job2 = new Job2();
		Thread t2 = new Thread(job2);
		t1.setName("My Thread 1");
		t2.setName("My Thread 2");
		t1.start();
		t2.start();
	}

}
