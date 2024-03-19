package com.wileyEdge.defaultandstatic;

public class DefaultAndStaticMethodsDemo {

	public static void main(String[] args) {
		WritableImpl w1= new WritableImpl();
		w1.abc();
		w1.write1();
		w1.write2();
		Writable1.pqr();
		Writable2.pqr();
	}

}
