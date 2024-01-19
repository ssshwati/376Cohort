package ExceptionHandling;

import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter numerator : ");
            int numerator = sc.nextInt();
            System.out.println("Enter denominator : ");
            int denominator = sc.nextInt();
            int result = divideNumbers(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed - " + e.getMessage());
        }
    }

    // Method to divide two numbers and throw an exception if the denominator is zero
    public static int divideNumbers(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numerator / denominator;
    }
}

