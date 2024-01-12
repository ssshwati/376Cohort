package com.stringAssignment;

import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a string input");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder stringBuilder = new StringBuilder(str);
        String reversedStr = stringBuilder.reverse().toString();
		String modifiedStr = String.join("-", reversedStr.split(""));
		System.out.println(modifiedStr);
	}

}

//Parse the String in the given format separated with ‘-’
//Sample input : computer
//Sample output : r-e-t-u-p-m-o-c