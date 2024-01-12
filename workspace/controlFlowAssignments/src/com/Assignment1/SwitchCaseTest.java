package com.Assignment1;

import java.util.Scanner;

public class SwitchCaseTest {

	public static boolean isVowel(char ch) {
		ch = Character.toLowerCase(ch);
		switch (ch) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;
		default:
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter any character ");
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		if (isVowel(ch)) {
			System.out.println(ch + " is a vowel.");
		} else {
			System.out.println(ch + " is not a vowel.");
		}
	}

}
