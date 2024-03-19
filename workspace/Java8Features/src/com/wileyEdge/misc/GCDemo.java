package com.wileyEdge.misc;

class Employee {
	public void doCoding() {
		System.out.println("Employee is coding");
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("I am removed from heap");
	}
}

public class GCDemo {

	public void doWork() {
		Employee e1 = new Employee();
		e1.doCoding();
		e1 = null;
	}

	public static void main(String[] args) {
		GCDemo demo = new GCDemo();
		demo.doWork();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
