package com.BankSystem;

import java.util.Scanner;
import com.BankSystem.Customer.Customer;
import com.Exp.CustomerNotFoundException;
import com.persistancefileSystem.FileSystemIdao;
import com.persistancefileSystem.Idao;

public class BankSystem {
	public static void main(String[] args)  { 
		BankSystemUtility bankSystemUtility = new BankSystemUtility();
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			bankSystemUtility.displayMenu();
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				bankSystemUtility.acceptCustomerData();
				break;
			case 2:
				bankSystemUtility.assignBankAccount();
				break;
			case 3:
				bankSystemUtility.showBalanceData();
				break;
			case 4:
				bankSystemUtility.sortCustomers();
				break;
			case 5:
				bankSystemUtility.persistance();
				break;
			case 6:
				// Show All Customers
				bankSystemUtility.showAllCustomers();
				break;
			case 7:
				try {
					bankSystemUtility.searchCustomersByName();
				} catch (CustomerNotFoundException e) {
					//e.printStackTrace();
				}
				break;
			case 8:
				bankSystemUtility.withdraw();
				break;
			case 9 :
				bankSystemUtility.deposit();
				break;
			case 10:
				bankSystemUtility.dao.saveAllCustomers(bankSystemUtility.customerList);
				System.out.println("Exiting the program. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 8.");
			}
		} while (choice != 10);
	}

}
