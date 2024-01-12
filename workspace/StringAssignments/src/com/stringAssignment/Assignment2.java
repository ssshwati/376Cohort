package com.stringAssignment;

import java.util.Scanner;

public class Assignment2 {

	// Remove all small ‘x’ and append at the end of the string
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		System.out.println("Enter a string input");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder modifiedStr = new StringBuilder();
		int countRemovedX = 0;
		for (char ch : str.toCharArray()) {
			if (ch != 'x') {
				modifiedStr.append(ch);
			} else {
				countRemovedX++;
			}
		}
		// Append 'x' at the end
		modifiedStr.append("x".repeat(countRemovedX));
		System.out.println(modifiedStr);
	}

}

//abcxXXcxerxxXXwer sample input
