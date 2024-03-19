package com.operators;

public class OperatorDemo {
	public static boolean isPositive(int a) {
		System.out.println("inside ispositive");
		if (a < 0) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		int b = 2;
		int c = a++ + ++b;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		int x = 5;
		int y = -3;
		if (isPositive(x) && isPositive(y)) {
			System.out.println("both positive");
		} else {
			System.out.println("both not positive");
		}
	}

}
