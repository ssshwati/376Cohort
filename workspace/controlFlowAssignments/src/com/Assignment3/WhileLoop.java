package com.Assignment3;

import java.util.Scanner;

public class WhileLoop {

	public static boolean isPalindrome(int number) {
		int originalNumber = number;
		int reversedNumber = 0;
		while (number > 0) {
			reversedNumber = reversedNumber * 10 + number % 10;
			number /= 10;
		}
		return originalNumber == reversedNumber;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter any number  ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (isPalindrome(num)) {
			System.out.println(num + " is a palindrome.");
		} else {
			System.out.println(num + " is not a palindrome.");
		}
	}

}
