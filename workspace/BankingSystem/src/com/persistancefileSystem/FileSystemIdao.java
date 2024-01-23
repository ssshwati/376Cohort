package com.persistancefileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.BankSystem.Customer.Customer;

public class FileSystemIdao implements Idao {

	private static final String FILE_NAME = "C:\\C376\\workspace\\BankingSystem\\customerData.txt";
	private static final String PASSPORT_NUMBERS_FILE = "C:\\C376\\workspace\\BankingSystem\\passportNumbers.txt";

	@Override
	public void saveAllCustomers(List<Customer> customerList) {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			objectOutputStream.writeObject(customerList);
			System.out.println("Customer data saved to file: " + FILE_NAME);
		} catch (IOException e) {
			System.err.println("Error saving customer data to file: " + e);
		}
	}

	@Override
	public List<Customer> retrieveAllCustomers() {
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			List<Customer> customerList = (List<Customer>) objectInputStream.readObject();
			System.out.println("Customer data retrieved from file: " + FILE_NAME);
			return customerList;
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error retrieving customer data from file: " + e.getMessage());
			return new ArrayList<>(); // Return an empty list in case of an error
		}
	}

	public Set<String> loadUniquePassportNumbers() {
		Set<String> uniquePassportNumbers;
		try (Scanner scanner = new Scanner(new File(PASSPORT_NUMBERS_FILE))) {
			uniquePassportNumbers = new HashSet<>();
			while (scanner.hasNext()) {
				uniquePassportNumbers.add(scanner.next());
			}
		} catch (FileNotFoundException e) {
			uniquePassportNumbers = new HashSet<>();
		}
		return uniquePassportNumbers;
	}

	// Save the set of unique passport numbers to the file
	public void saveUniquePassportNumbers(Set<String> uniquePassportNumbers) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(PASSPORT_NUMBERS_FILE))) {
			for (String passport : uniquePassportNumbers) {
				writer.println(passport);
			}
		} catch (IOException e) {
			// Handle the exception (e.g., log the error)
			e.printStackTrace();
		}
	}

}
