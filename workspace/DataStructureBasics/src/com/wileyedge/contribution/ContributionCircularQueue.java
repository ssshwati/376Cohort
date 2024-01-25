package com.wileyedge.contribution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ContributionCircularQueue {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Read input from STDIN
		int n = scanner.nextInt();
		Queue<Integer> lastYearContributions = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			lastYearContributions.add(scanner.nextInt());
		}

		// Calculate new contributions
		Queue<Integer> newContributions = calculateContributions(lastYearContributions);

		// Print the output to STDOUT
		for (int contribution : newContributions) {
			System.out.print(contribution + " ");
		}
	}

	public static Queue<Integer> calculateContributions(Queue<Integer> lastYearContributions) {
		int n = lastYearContributions.size();
		Queue<Integer> newContributions = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			// Calculate the sum of contributions of the two neighbors to the left
			int leftNeighbor1 = lastYearContributions.poll();
			lastYearContributions.add(leftNeighbor1);

			int leftNeighbor2 = lastYearContributions.poll();
			lastYearContributions.add(leftNeighbor2);

			// Calculate the new contribution for the current apartment
			int newContribution = leftNeighbor1 + leftNeighbor2;
			newContributions.add(newContribution);
		}

		return newContributions;
	}
}
