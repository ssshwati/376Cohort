package com.wileyedge.contribution;

import java.util.ArrayList;
import java.util.Scanner;

public class ContributionArrayList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Read input from STDIN
		System.out.println("Enter total no of last year contributions : ");
		int n = scanner.nextInt();
		ArrayList<Integer> lastYearContributions = new ArrayList<>();

		System.out.println("Enter "+n+" values of last year contributions : ");
		for (int i = 0; i < n; i++) {
			lastYearContributions.add(scanner.nextInt());
		}

		// Calculate new contributions
		ArrayList<Integer> newContributions = calculateContributions(lastYearContributions);

		// Print the output to STDOUT
		System.out.println("Values of current year contributions : ");
		for (int contribution : newContributions) {
			System.out.print(contribution + " ");
		}
	}

	public static ArrayList<Integer> calculateContributions(ArrayList<Integer> lastYearContributions) {
		int n = lastYearContributions.size();
		ArrayList<Integer> newContributions = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			// Calculate the sum of contributions of the two neighbors to the left
			int leftNeighbor1 = lastYearContributions.get((i + 1 + n) % n);
			int leftNeighbor2 = lastYearContributions.get((i + 2 + n) % n);

			// Calculate the new contribution for the current apartment
			int newContribution = leftNeighbor1 + leftNeighbor2;
			newContributions.add(newContribution);
		}

		return newContributions;
	}
}
