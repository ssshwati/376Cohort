package com.stringAssignment;

import java.util.Scanner;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a string input");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char firstChar = str.charAt(0);
		char lastChar = str.charAt(str.length() - 1);
		String modifiedStr = lastChar + str.substring(1, str.length() - 1) + firstChar;
		System.out.println(modifiedStr);
	}

}

//
//3) Replace the first and last characters in the given string
//Sample input : Hello World
//Sample output: dello WorlH