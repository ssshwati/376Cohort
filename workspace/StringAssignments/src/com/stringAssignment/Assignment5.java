package com.stringAssignment;

import java.util.Scanner;

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a string input");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String modifiedStr = "";
		for (String s : str.split(" ")) {
			modifiedStr+=s.charAt(0);
		}
		System.out.println(modifiedStr);
	}

}


//5) Given input as : “Softra Services Limited”
//Output should be like: SSL