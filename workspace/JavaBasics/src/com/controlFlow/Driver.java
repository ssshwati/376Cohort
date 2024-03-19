package com.controlFlow;

import java.util.*;

import java.io.*;

import java.lang.*;

//{ Driver Code Starts //Initial Template for Java
class Driver

{
	public static void main(String args[]) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			String str = read.readLine();
			System.out.println(new Reverse().reverseWord(str));
		}
	}

}

class Reverse {
	public static String reverseWord(String str) {
//		Scanner sc = new Scanner(System.in);
//		String s1 = "";
//		s1 = sc.nextLine();
//		String s2 = "";
//		for (int i = s1.length() - 1; i >= 0; i--) {
//			s2 = s2 + s1.charAt(i);
//		}
//
//		System.out.println("reversed string: " + s2);
//		return s2;

		String reversedString = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reversedString += str.charAt(i);
		}
		return reversedString;
	}

}
