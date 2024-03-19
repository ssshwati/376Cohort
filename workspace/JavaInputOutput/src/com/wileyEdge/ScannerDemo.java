package com.wileyEdge;

import java.util.Scanner;

public class ScannerDemo {

	public ScannerDemo() {
		
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("What's your name ? ");
			String input = scanner.nextLine();
			if( input.isEmpty()) {
				break;
			}
			System.out.println("welcome "+input);
		}
		scanner.close();
		System.out.println("bye");
	}
}
