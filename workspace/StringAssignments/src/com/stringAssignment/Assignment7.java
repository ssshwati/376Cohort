package com.stringAssignment;

import java.util.Scanner;

public class Assignment7 {

	public static void main(String[] args) {

		System.out.println("Enter a string input");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		StringBuilder result = new StringBuilder();
		for (char ch : str.toCharArray()) {
			if (Character.isLetter(ch)) {
				char base = Character.isLowerCase(ch) ? 'a' : 'A';
				result.append((char) ((ch - base + 1) % 26 + base));
			}
			else
			{
				result.append(ch);
			}
		}
		System.out.println(result);
	}

}
