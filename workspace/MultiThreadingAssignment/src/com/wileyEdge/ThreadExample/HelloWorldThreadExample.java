package com.wileyEdge.ThreadExample;

//class HelloWorldThread extends Thread {
//	@Override
//	public void run() {
//		System.out.println("Hello World from Thread!");
//	}
//}

class HelloWorldThread implements Runnable{
	@Override
	public void run() {
		System.out.println("Hello World from Thread!");
	}
	
}
public class HelloWorldThreadExample {
	public static void main(String[] args) {
		HelloWorldThread helloThread = new HelloWorldThread();
		Thread thread = new Thread(helloThread);
		thread.start();
		System.out.println("Hello World from Main Thread!");
	}
}
