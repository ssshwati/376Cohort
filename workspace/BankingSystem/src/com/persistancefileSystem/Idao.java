package com.persistancefileSystem;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.BankSystem.Customer.Customer;

public interface Idao {
	List<Customer> retrieveAllCustomers();
	void saveAllCustomers(List<Customer> customerList);
	void saveUniquePassportNumbers(Set<String> uniquePassportNumbers);
	Set<String> loadUniquePassportNumbers();
}
