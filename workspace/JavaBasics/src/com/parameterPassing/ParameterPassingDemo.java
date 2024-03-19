package com.parameterPassing;

class Num {
	public int n;
}

public class ParameterPassingDemo {
	public void modify(int n) {
		System.out.println("inside modify method");
		n = 10;
		System.out.println("inside modify method " + n);
		System.out.println("exiting modify method");
	}

	public void modify(Num num) {
		System.out.println("inside modify method accepting Num");
		num.n = 10;
		System.out.println("inside modify method " + num.n);
		System.out.println("exiting modify method accepting Num");
	}

	public void modify(String str) {
		System.out.println("inside modify method accepting String");
		str = "10";
		System.out.println("inside modify method " + str);
		System.out.println("exiting modify method accepting String");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("inside main method");
		ParameterPassingDemo demo = new ParameterPassingDemo();
		int n = 5;
		System.out.println("before invoking modify method " + n);
		demo.modify(n);
		System.out.println("after invoking modify method " + n);
		System.out.println("===================================");
		Num num = new Num();
		num.n = 5;
		System.out.println("before invoking modify method accepting Num " + num.n);
		demo.modify(num);
		System.out.println("after invoking modify method accepting Num " + num.n);
		System.out.println("exiting main method");
		System.out.println("===================================");
		String str = "5";
		System.out.println("before invoking modify method accepting String " + str);
		demo.modify(str);
		System.out.println("after invoking modify method accepting String " + str);
		System.out.println("exiting main method");
	}

}
