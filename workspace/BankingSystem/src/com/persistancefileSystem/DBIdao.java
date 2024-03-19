package com.persistancefileSystem;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;



import com.BankSystem.Customer.Customer;

public interface DBIdao {
	void saveAllCustomersDB(List<Customer> customerList);
}



