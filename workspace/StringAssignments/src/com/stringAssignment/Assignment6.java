package com.stringAssignment;

import java.util.Scanner;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a string input");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String modifiedStr = "";

		int i = 0;
		for (String s : str.split(" ")) {
			modifiedStr+=s.charAt(i);
			i++;
		}
		System.out.println(modifiedStr.toUpperCase());
	}

}

//
//Given input as : “Softra Services Limited” < first char from 1st word, 2nd char from 
//second word, 3rd char from 3rd word etc.>> Output should be in capitals at the end.
//Output should be like: SEM