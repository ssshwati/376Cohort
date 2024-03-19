package com.controlFlow;

public class FormatSpecifier {
	public static void main (String[] args) { 
		int a=10000; 
		double b = 343.125452682;
		System.out.printf("%,d%n",a); 
		System.out.printf("%5.3f\n",b);
	} 
}
