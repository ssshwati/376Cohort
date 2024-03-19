package com.wileyEdge.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSetMetaData;

public class jdbcDemo {
	public static void main(String[] args) {
		/*
		 * 1. load and register JDBC driver (type 4) 
		 * 2. Get the Connection object by passing URL, username, password of data base 
		 * 3. Get the Statement from the connection 
		 * 4. Get the ResultSet from the Statement 
		 * 5. print Result
		 */
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Type 4 driver of mysql is loaded into memory ");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empmgmt", "root", "root");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empmgmt?useSSL=false","root","root");
			System.out.println("connection established " + con.toString());
			
			
//			Use SSL toggles SSL encryption. We would typically set this to true, but for our local development, 
//			it would be overkill to set up the infrastructure. We default to false for this activity.
//			insert
//			update
//			executeUpdate();
			
			Statement stat = con.createStatement();
//			String insert = "insert into dept values(60,'Tech','Bangalore')";
//			int n = stat.executeUpdate(insert);
//			System.out.println(n + " rows inserted");
			
			String update = "update dept set loc = 'Patna' where deptid = 60";
			int n = stat.executeUpdate(update);
			System.out.println(n + " rows updated");
			
			String delete = "delete from dept where deptid = 70";
			n = stat.executeUpdate(delete);
			System.out.println(n + " rows deleted");
			
			String select = "select * from dept";
			ResultSet rs = stat.executeQuery(select);
			ResultSetMetaData rsm = rs.getMetaData();
			System.out.println(rsm.getColumnName(1) + "\t" + rsm.getColumnName(2)+ "\t\t" + rsm.getColumnName(3));
			while (rs.next()) {
                int id = rs.getInt("deptid");
                String name = rs.getString("dname");
                String city = rs.getString("loc");
                System.out.println(id + "\t" + name + "\t\t" + city);
            }
			
//			CRUD
//			C - Create (Insert)
//			R - Retrieve (select)
//			U - Update (update)
//			D - Delete (delete)
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}


