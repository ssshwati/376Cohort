package com.Assignment2;

import java.util.Scanner;

public class ForLoopTest {

	private static long calculateFactorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
		}
		long factorial = 1;
		for (int i = 2; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter any number  ");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.println(calculateFactorial(x));
	}

}
