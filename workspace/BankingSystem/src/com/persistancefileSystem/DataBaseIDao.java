package com.persistancefileSystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.BankSystem.Customer.Customer;

public class DataBaseIDao implements DBIdao {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bankingSystem";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	@Override
	public void saveAllCustomersDB(List<Customer> customerList) {
		String sql = "INSERT INTO customer (customer_id,customer_name, age, mobile_number, passport_number, dob) VALUES (?,?, ?, ?, ?, ?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Type 4 driver of mysql is loaded into memory");
			Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			System.out.println("Connection successful");
			String query = "INSERT INTO student (sname, age, mobile, email,address) VALUES (?, ?, ?, ?,?)";
			for (Customer customer : customerList) {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, customer.getCustomerName());
				preparedStatement.setInt(2, customer.getAge());
				preparedStatement.setLong(3, customer.getMobileNumber());
				preparedStatement.setString(4, customer.getPassportNumber());
//				Date dob =  java.sql.Date.valueOf(customer.getDobString());
//				preparedStatement.setString(5, dob);
				preparedStatement.setString(5, "12-02-2000");
				preparedStatement.executeUpdate();
				System.out.println("Executed Query");
			}
			System.out.println("Customer data saved to database.");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
