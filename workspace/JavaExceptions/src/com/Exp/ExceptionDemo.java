package com.Exp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionDemo {

	public void method1(int x) {
		method2();
		System.out.println("inside method1");
		try {
			System.out.println("starting divison");
			int r = 10 / x;
			System.out.println("divided");
		} catch (ArithmeticException | NullPointerException exe) {
			System.out.println("don't divide by zero");
		} catch (Exception e) {
			System.out.println("Exception class ");
		} finally {
			//cleanUp activity related code
			System.out.println("always executed");
		}
		System.out.println("exiting method1");
	}

	public void method2()
	{
		System.out.println("inside method2");
		try {
			FileInputStream fis = new FileInputStream("C:\\C376\\abc.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found");
			//e.printStackTrace();
		}
		System.out.println("exiting method2");
	}
	
	public void method3(){
		System.out.println("inside method3");
		BankAccount acct = new BankAccount();
		try {
			acct.withDraw(200);
		} catch (InsufficientFundsException e) {
			//e.printStackTrace();
			System.out.println("not available enough balance");
		}
		System.out.println("exiting method3");
	}
	
	public static void main(String[] args) {
		System.out.println("inside main");
		ExceptionDemo demo = new ExceptionDemo();
		//demo.method1(0);
		demo.method3();
		System.out.println("exiting main");
	}

}
