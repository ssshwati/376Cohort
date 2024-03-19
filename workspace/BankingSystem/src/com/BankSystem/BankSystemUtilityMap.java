//package com.BankSystem;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//import com.Account.Account;
//import com.Account.FixedDeposit.FixedDeposit;
//import com.Account.SavingAccount.SavingAccount;
//import com.BankSystem.Customer.Customer;
//
//import com.Exp.CustomerNotFoundException;
//import com.Exp.InsufficientInitialBalanceException;
//import com.persistancefileSystem.FileSystemIdao;
//import com.persistancefileSystem.Idao;
//
//public class BankSystemUtilityMap {
//	// Map<Integer, Customer> customerMap = new HashMap<>();
//	Idao dao;
//	Map<Integer, Customer> customerMap;
//	
//    public BankSystemUtilityMap() {
//    	dao = new FileSystemIdao();
//    	customerMap = new HashMap<>();
//    	customerMap  = dao.retrieveAllCustomers();
//    	for (Customer customer : customerMap.values()) {
//			System.out.println("Customer Details: \n" + customer);
//			System.out.println("Bank Account Details: \n" + customer.getBankAccount());
//		}
//    }
//    
//	public void displayMenu() {
//		System.out.println("============================================");
//		System.out.println("Menu:");
//		System.out.println("1. Create New Customer Data");
//		System.out.println("2. Assign a Bank Account to a Customer");
//		System.out.println("3. Display Balance or Interest Earned of a Customer");
//		System.out.println("4. Sort Customer Data");
//		System.out.println("5. Persist Customer Data");
//		System.out.println("6. Show All Customers");
//		System.out.println("7. Search Customers by Name");
//		System.out.println("8. Withdraw Amount");
//		System.out.println("9. Deposit Amount");
//		System.out.println("10. Exit");
//	}
//
//	// case 1
//	public void acceptCustomerData() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Enter Customer Name : ");
//		String name = scanner.next();
//		System.out.print("Enter Age: ");
//		int age = scanner.nextInt();
//		System.out.print("Enter Mobile Number : ");
//		long mobile = scanner.nextLong();
//		System.out.print("Enter passport Number : ");
//		String passport = scanner.next();
//		int nextCustomerId = Customer.getNextCustomerId();
//		Customer newCustomer = new Customer(name, age, mobile, passport);
//		customerMap.put(newCustomer.getCustomerId(), newCustomer);
//		System.out.println("============================================");
//		System.out.println("Customer created with ID: " + (nextCustomerId));
//	}
//
//	// case 2
//	public void assignBankAccount() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Enter Customer ID: ");
//		int customerId = scanner.nextInt();
//		if (customerMap.containsKey(customerId)) {
//			Customer customer = customerMap.get(customerId);
//			// Check if the customer already has a bank account
//			if (customer.getBankAccount() != null) {
//				System.out.println("This customer already has a bank account.");
//			} else {
//				System.out.print("Enter Account Number: ");
//				long accountNumber = scanner.nextLong();
//				System.out.print("Enter BSB Code: ");
//				long bsbCode = scanner.nextLong();
//				System.out.print("Enter Bank Name: ");
//				String bankName = scanner.next();
//				System.out.print("Enter Initial Balance: ");
//				double balance = scanner.nextDouble();
//				System.out.print("Enter Opening Date (DD/MM/YYYY): ");
//				String openingDate = scanner.next();
//
//				boolean isAccountassigned = false;
//				String accountType = "";
//				do {
//					System.out.print("Enter 1 for savings account and 2 for fixedDeposit account ");
//					int choice = scanner.nextInt();
//					switch (choice) {
//						case 1:
//							accountType = "SavingAccount";
//							boolean isSalaryAccount;
//							int minimumBalance;
//							System.out.print("Is this your salary account ? YES/NO ");
//							if (scanner.next().toLowerCase() == "yes") {
//								isSalaryAccount = true;
//							} else {
//								isSalaryAccount = false;
//							}
//							do {
//								System.out.print("Enter minimum deposit ( it must be more than 100 ) ");
//								minimumBalance = scanner.nextInt();
//							} while (minimumBalance < 100);
//
//							if (!isSalaryAccount && balance < minimumBalance) {
//								try {
//									throw new InsufficientInitialBalanceException(
//											"Cannot create Savings Account. Initial balance should be at least "
//													+ minimumBalance + " $");
//								} catch (InsufficientInitialBalanceException e) {
//									System.out.println("Error: " + e.getMessage());
//									// Handle the error appropriately or rethrow if needed
//								}
//							} else {
//								SavingAccount savingAccount = new SavingAccount(accountNumber, bsbCode, bankName,
//										balance,openingDate,isSalaryAccount,minimumBalance);
//								// Set the Bank Account for the Customer sprint2
//								customer.setBankAccount(savingAccount);
//								System.out.println("============================================");
//								System.out.println("Bank Account assigned to Customer ID: " + customerId);
//								isAccountassigned = true;
//							}
//							break;
//						case 2:
//							accountType = "FixedDeposit";
//							FixedDeposit FDAccount = new FixedDeposit(accountNumber, bsbCode, bankName, balance,
//									openingDate);
//							// Set the Bank Account for the Customer
//							customer.setBankAccount(FDAccount);
//							System.out.println("============================================");
//							System.out.println("Bank Account assigned to Customer ID: " + customerId);
//							isAccountassigned = true;
//							break;
//						default:
//							System.out.println("============================================");
//							System.out.println("wrong choice.....");
//					}
//				} while (!isAccountassigned);
//				System.out.println("Bank Account Details for Customer ID " + customerId + " :\n"
//						+ customer.getBankAccount());
//				if (accountType.equals("Savings")) {
//					((SavingAccount) customer.getBankAccount()).displaySavingsAccountDetails();
//				} else if (accountType.equals("FixedDeposit")) {
//					((FixedDeposit) customer.getBankAccount()).displayFixedDepositAccountDetails();
//				}
//			}
//		} else {
//			System.out.println("============================================");
//			System.out.println("Invalid Customer ID");
//		}
//	}
//
//	// case 3
//	public void showBalanceData() {
//		System.out.println("============================================");
//		System.out.print("Enter Customer ID: ");
//		Scanner scanner = new Scanner(System.in);
//		int customerId = scanner.nextInt();
//		// if (customerId >= 100 && customerId < Customer.getNextCustomerId()) {
//		if (customerMap.containsKey(customerId)) {
//			Customer customer = customerMap.get(customerId);
//			displayBalanceOrInterest(customer);
//		} else {
//			System.out.println("============================================");
//			System.out.println("Invalid Customer ID. Please enter a valid ID.");
//		}
//	}
//
//	private void displayBalanceOrInterest(Customer customer) {
//		Account account = customer.getBankAccount();
//		System.out.println("============================================");
//		if (account instanceof SavingAccount) {
//			SavingAccount savingsAccount = (SavingAccount) account;
//			System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
//			System.out.println("Interest Earned: " + savingsAccount.calculateInterest());
//		} else if (account instanceof FixedDeposit) {
//			FixedDeposit fixedDepositAccount = (FixedDeposit) account;
//			System.out.println("Fixed Deposit Account Balance: " + fixedDepositAccount.getBalance());
//			System.out.println("Interest Earned: " + fixedDepositAccount.calculateInterest());
//		} else {
//			System.out.println("============================================");
//			System.out.println("No valid account found for the customer.");
//		}
//	}
//
//	// case 4
//	public void sortCustomers() {
//		System.out.println("============================================");
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Sort Customers by:");
//		System.out.println("1. Customer IDs");
//		System.out.println("2. Customer Names");
//		System.out.println("3. Bank Balances");
//		System.out.print("Enter your choice: ");
//		int sortChoice = scanner.nextInt();
//		List<Customer> sortedCustomers = new ArrayList<>(customerMap.values());
//
//		switch (sortChoice) {
//			case 1:
//				// Sort by Customer IDs
//				Collections.sort(sortedCustomers);
//				showSortedCustomers(sortedCustomers);
//				break;
//
//			case 2:
//				// Sort by Customer Names
//				Collections.sort(sortedCustomers, new CustomerNameComparator());
//				showSortedCustomers(sortedCustomers);
//				break;
//
//			case 3:
//				// Sort by Bank Balances
//				Collections.sort(sortedCustomers, new CustomerBalanceComparator());
//				showSortedCustomers(sortedCustomers);
//				break;
//
//			default:
//				System.out.println("Invalid choice. Sorting canceled.");
//		}
//	}
//
//	public static void showSortedCustomers(List<Customer> sortedCustomers) {
//		System.out.println("============================================");
//		for (Customer customer : sortedCustomers) {
//			System.out.println("Customer ID: " + customer.getCustomerId());
//			System.out.println("Customer Details: \n" + customer);
//			System.out.println("Bank Account Details: \n" + customer.getBankAccount());
//		}
//	}
//
//	//case5
//	public void persistance(){
//		System.out.print("Enter your persistance choice " );
//		System.out.print("Enter 1 for File System & 2 for DataBase ");
//		Scanner scanner = new Scanner(System.in);
//		int persistenceChoice = scanner.nextInt();
//		switch (persistenceChoice) {
//			case 1:
//				// Save all customers to file
//				dao.saveAllCustomers(customerMap);
//				break;
//			default:
//				System.out.println("Invalid choice.");
//				break;
//		}
//	}
//
//
//	// case 6
//	public void showAllCustomers() {
//		System.out.println("============================================");
//		System.out.println(" All customers Data");
//		for (Customer customer : customerMap.values()) {
//			System.out.println("Customer Details: \n" + customer);
//			System.out.println("Bank Account Details: \n" + customer.getBankAccount());
//		}
//	}
//
//	// case 7
//	public void searchCustomersByName() throws CustomerNotFoundException {
//		boolean customerFound = false;
//		int nextCustomerId = Customer.getNextCustomerId();
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("============================================");
//		System.out.print("Enter Customer Name to search: ");
//		String searchName = scanner.next();
//		for (Customer customer : customerMap.values()) {
//			if (customer.getCustomerName().equalsIgnoreCase(searchName)) {
//				System.out.println("Customer found:");
//				System.out.println(customer);
//				System.out.println("Bank Account Details: \n" + customer.getBankAccount());
//				customerFound = true;
//			}
//		}
//		if (!customerFound) {
//			System.out.println("No customer found with the name: " + searchName);
//			throw new CustomerNotFoundException("No customer found with the name: " + searchName);
//		}
//	}
//
//	// case 8
//	public void withdraw() {
//		System.out.println("============================================");
//		System.out.print("Enter Customer ID to whom you want to withdraw : ");
//		Scanner scanner = new Scanner(System.in);
//		int customerId = scanner.nextInt();
//		if (customerMap.containsKey(customerId)) {
//			Customer customer = customerMap.get(customerId);
//			if (customer.getBankAccount() == null) {
//				System.out.println("This customer doesn't have any bank account.");
//			} else {
//				System.out.print("Enter withdrawal amount: ");
//				double withdrawalAmount = scanner.nextDouble();
//				customer.withdraw(withdrawalAmount);
//			}
//		} else {
//			System.out.println("INVALID customer ID");
//		}
//	}
//
//	// case 9
//	public void deposit() {
//		System.out.println("============================================");
//		System.out.print("Enter Customer ID for whom you want to deposit : ");
//		Scanner scanner = new Scanner(System.in);
//		int customerId = scanner.nextInt();
//		if (customerMap.containsKey(customerId)) {
//			Customer customer = customerMap.get(customerId);
//			if (customer.getBankAccount() == null) {
//				System.out.println("This customer doesn't have any bank account.");
//			} else {
//				System.out.print("Enter deposit amount: ");
//				double depositAmount = scanner.nextDouble();
//				customer.deposit(depositAmount);
//			}
//		} else {
//			System.out.println("INVALID customer ID");
//		}
//	}
//}
//
//// Comparator for comparing customers by ID
//class CustomerNameComparator implements Comparator<Customer> {
//	@Override
//	public int compare(Customer customer1, Customer customer2) {
//		return customer1.getCustomerName().compareTo(customer2.getCustomerName());
//	}
//}
//
//// Comparator for comparing customers by bank balance
//class CustomerBalanceComparator implements Comparator<Customer> {
//	@Override
//	public int compare(Customer customer1, Customer customer2) {
//		return Double.compare(customer1.getBankAccount().getBalance(), customer2.getBankAccount().getBalance());
//	}
//}