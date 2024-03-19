package com.controlFlow;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number");
		
		String number=sc.nextLine();
		int n=Integer.parseInt(number);
		System.out.println("You have entered "+n);
	
	}

}
