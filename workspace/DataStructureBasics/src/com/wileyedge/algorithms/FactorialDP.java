package com.wileyedge.algorithms;

public class FactorialDP {
	public static int factorialRecursive(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * factorialRecursive(n - 1);
		}
	}

	public static int factorialTabulation(int n) {
		int[] table = new int[n + 1];
		table[0] = 1;
		for (int i = 1; i <= n; i++) {
			table[i] = i * table[i - 1];
		}
		return table[n];
	}
	
	public static int factorialMemoization(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n] == 0) {
            memo[n] = n * factorialMemoization(n - 1, memo);
        }
        return memo[n];
    }


	public static void main(String[] args) {
		System.out.println(args[0]+" "+args[1]);
		int n =5;
		System.out.println("Factorial (Plain Recursion): " + factorialRecursive(5));
		System.out.println("Factorial (Tabulation): " + factorialTabulation(5));
		int[] memo = new int[n+1];
		System.out.println("Factorial (Memoization): " + factorialMemoization(5, memo));
	}
}
