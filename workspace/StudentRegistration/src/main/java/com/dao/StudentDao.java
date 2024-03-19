package com.dao;
//

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import com.softra.model.Student;
//
//public class StudentDao {
//    // Method to save student data to database
//    public void saveStudent(Student student) {
//        // Database connection logic
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            // Establish database connection
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentRegistration", "root", "root");
//            // SQL query to insert student data
//            String sql = "INSERT INTO students (name, age, mobile, email, address) VALUES (?, ?, ?, ?, ?)";
//
//            // Create prepared statement
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, student.getName());
//            pstmt.setInt(2, student.getAge());
//            pstmt.setLong(3, student.getMobile());
//            pstmt.setString(4, student.getEmail());
//            pstmt.setString(5, student.getAddress());
//
//            // Execute the query
//            pstmt.executeUpdate();
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // Close resources
//            try {
//                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.softra.model.Student;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDao {
	private String jdbcUrl;
	private String jdbcUsername;
	private String jdbcPassword;

	public StudentDao(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
		this.jdbcUrl = jdbcUrl;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	public void saveStudent(Student student) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Type 4 driver of mysql is loaded into memory");
			Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
			System.out.println("Connection successful");
			String query = "INSERT INTO student (sname, age, mobile, email,address) VALUES (?, ?, ?, ?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setLong(3, student.getMobile());
			preparedStatement.setString(4, student.getEmail());
			preparedStatement.setString(5, student.getAddress());
			preparedStatement.executeUpdate();
			System.out.println("Executed Query");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
