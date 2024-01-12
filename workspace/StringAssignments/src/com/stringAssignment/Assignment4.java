package com.stringAssignment;

import java.util.Scanner;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a string input");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String maxLengthSubstring = "";

		for (String word : str.split(" ")) {
			if (word.length() > maxLengthSubstring.length()) {
				maxLengthSubstring = word;
			}
		}
		System.out.println(maxLengthSubstring);
	}

}

//
//Find the substring which is having max length, if two strings lengths are equal 
//return the first one.
//Sample input 1 : “Hi How are you”
//Sample output 1 : How
//Sample input 2 : “This is java String program ”
//Sample output 2 : program