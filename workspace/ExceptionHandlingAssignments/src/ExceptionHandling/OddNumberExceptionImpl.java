package ExceptionHandling;

import java.util.Scanner;

class OddNumberException extends Exception {
	public OddNumberException(String message) {
		super(message);
	}
}

public class OddNumberExceptionImpl {
	public static void main(String[] args) {
		try {
			System.out.println("Enter a number ");
			Scanner sc = new Scanner(System.in);
			int numberToCheck = sc.nextInt(); 
			if (numberToCheck % 2 != 0) {
				throw new OddNumberException("Error: The number is odd.");
			}
			System.out.println(numberToCheck + " is an even number.");
		} catch (OddNumberException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("GOOD BYE");
		}
	}
}
