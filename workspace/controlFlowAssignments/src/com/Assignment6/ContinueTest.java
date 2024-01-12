package com.Assignment6;

public class ContinueTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Even numbers between 1 and 100:");
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				continue; // Skip odd numbers
			}
			System.out.print(i + " ");
		}
	}

}
