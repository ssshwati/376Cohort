package com.Assignment4;

public class DoWhileLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 10;
		System.out.println("First " + count + " numbers of the Fibonacci series:");
		int first = 0, second = 1;
		int i = 0;
		do {
			System.out.print(first + " ");
			int next = first + second;
			first = second;
			second = next;
			i++;
		} while (i < count);
	}

}
