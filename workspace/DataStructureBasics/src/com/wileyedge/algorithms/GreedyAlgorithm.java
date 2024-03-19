package com.wileyedge.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyAlgorithm {
	public static boolean checkConstraints(int value, int lowerLimit, int upperLimit) {
        if (value < lowerLimit || value > upperLimit) {
            System.out.println("not valid input, enter any number between "+lowerLimit+" & "+upperLimit);
            return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter no of test cases ");
		int t = scanner.nextInt(); // Number of test cases
		if (!checkConstraints(t, 1, 100)) {
            return;
        }
		for (int i = 0; i < t; i++) {
			System.out.println("enter no of bottles ");
			int n = scanner.nextInt();
			if (!checkConstraints(n, 1, 10000)) {
	            return;
	        }
			System.out.println("enter capacity of container ");
			int x = scanner.nextInt();
			if (!checkConstraints(x, 1, 1000000000)) {
	            return;
	        }
			int[] bottleCapacities = new int[n];
			System.out.println("enter bottle capacities ");
			for (int j = 0; j < n; j++) {
				bottleCapacities[j] = scanner.nextInt();
			}
			Arrays.sort(bottleCapacities);

			int maxBottles = 0;
			int totalCapacity = 0;

			for (int j = 0; j < n; j++) {
				if (totalCapacity + bottleCapacities[j] <= x) {
					totalCapacity += bottleCapacities[j];
					maxBottles++;
				}
			}
			System.out.println("maximum bottles filled is : "+maxBottles);
		}
	}
}
