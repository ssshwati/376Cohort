package com.BeerBottlePackage;

import java.util.Scanner;

public class GamePlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		int totalBottles = 21;

		System.out.println("Welcome to the game 21 beer bottles...");
		System.out.println("There are 21 beer bottles...");
		System.out.println("There are 2 players - Computer and you.");
		System.out.println("At a time, each one can pick up any no. of bottles ");
		System.out.println("between 1 and 4 (inclusive)");
		System.out.println("Will you like to play first?");

		String playerResponse = scanner.nextLine();
		int userPick;
		int computerPick;

		if (playerResponse.toLowerCase().equals("yes")) {
			while (totalBottles > 0) {
				System.out.println("How many bottles you would like to pick up?");
				userPick = scanner.nextInt();
				if (userPick < 1 || userPick > 4) {
					System.out.println("you are supposed to enter any value between 1 and 4 (inclusive)");
					continue;
				}else if(userPick > totalBottles) {
					System.out.println("you can not pick bottles more than remaining no of bottles");
					continue;
				}
				totalBottles -= userPick;
				
				if (totalBottles == 0) {
					System.out.println("You had to pick up the last..you are the loser");
					System.out.println("Computer wins! You have to pay the bill.");
					break;
				}

				computerPick = 5 - userPick;
				System.out.println(" Computer has picked : " + computerPick);
				totalBottles -= computerPick;
				System.out.println(" The bottles remaining are : " + totalBottles);

			}

		} else {
			System.out.println("Invalid input. You need to be the first Player,");
			System.out.println(" Exiting the game. Try again later !! ");
		}

	}

}
