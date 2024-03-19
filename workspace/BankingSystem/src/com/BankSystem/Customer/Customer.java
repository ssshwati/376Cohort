package com.BankSystem.Customer;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

import com.Account.Account;

public class Customer implements Serializable, Comparable<Customer> {
	private Account bankAccount;
	private static int nextCustomerId = 100;
	private int customerId;
	private String customerName;
	private int age;
	private long mobileNumber;
	private String passportNumber;
	private String dobString = null;
	LocalDate dob;

	// parameterized constructor accepting only age and name
	public Customer(String customerName, long mobile, String passport) {
		this.customerId = nextCustomerId++;
		this.customerName = customerName;
		this.age = age;
		this.mobileNumber = mobile;
		this.passportNumber = passport;
		this.bankAccount = null;
		do {
			System.out.print("Please enter Date of Birth (YYYY-MM-DD): ");
			Scanner scanner = new Scanner(System.in);
			dobString = scanner.next();
		} while (!setDOB(dobString));
		this.age = calculateAge(dobString);
	}

	public int calculateAge(String dobString) {
		LocalDate dob = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate currentDate = LocalDate.now();
		return Period.between(dob, currentDate).getYears();
	}

	@Override
	public int compareTo(Customer other) {
		// Compare based on customer ID
		return this.getCustomerId() - other.getCustomerId();
	}

	// Getter for customer ID
	public int getCustomerId() {
		return customerId;
	}

	public static int getNextCustomerId() {
		return nextCustomerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public boolean setDOB(String dob) {
		// Validate Date of Birth format (DD/MM/YYYY)
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.dob = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			return true;
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
			return false;
		}
	}

	public Account getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Account bankAccount) {
		this.bankAccount = bankAccount;
	}

	// Deposit money into the customer's account
	public void deposit(double amount) {
		if (amount > 0) {
			this.getBankAccount().setBalance(this.getBankAccount().getBalance() + amount);
			System.out.println("Deposit successful. New balance: " + this.getBankAccount().getBalance());
		} else {
			System.out.println("Invalid deposit amount. Please enter a positive amount.");
		}
	}

	// Withdraw money from the customer's account
	public void withdraw(double amount) {
		if (amount > 0) {
			double currentBalance = this.getBankAccount().getBalance();
			if (currentBalance >= amount) {
				this.getBankAccount().setBalance(currentBalance - amount);
				System.out.println("Withdrawal successful. New balance: " + this.getBankAccount().getBalance());
			} else {
				System.out.println(
						"Insufficient funds. Cannot withdraw " + amount + ". Current balance: " + currentBalance);
			}
		} else {
			System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
		}
	}

	// Updated toString method
	@Override
	public String toString() {
		return "Customer ID: " + customerId + "\nName: " + customerName + "\nAge: " + age + "\nDOB : " +(dob != null ? dob.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : "N/A") + "\nMobile Number: "
				+ mobileNumber + "\nPassport Number: " + (passportNumber != null ? passportNumber : "N/A");
	}

	public static void setNextCustomerId(int i) {
		Customer.nextCustomerId = i;
	}

	public int getAge() {
		return age;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public String getDobString() {
		return dobString;
	}
	
	

}
