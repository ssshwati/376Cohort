package com.Assignment5;

public class BreakTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Prime numbers between 1 and 100:");
		for (int num = 2; num <= 100; num++) {
			 boolean isPrime = true;
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					 isPrime = false;
					break; // Not a prime number
				}
			}
			if(isPrime)
			{
				 System.out.print(num + " ");
			}
		}
	}

}
