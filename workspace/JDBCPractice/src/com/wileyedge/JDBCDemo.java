package com.wileyedge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
//	5 steps to connect java application using jdbc
//	Register the Driver
//	Create a Connection
//	Create SQL Statement
//	Execute SQL Statement
//	Closing the connection
	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","root");
			System.out.println(con);
			
			String sql = "CREATE TABLE BLOBDEMO1 (EMP_ID INT NOT NULL,PHOTO blob,PRIMARY KEY (EMP_ID)) ENGINE=INNODB";
			Statement s=con.createStatement();
//			s.execute(sql);
			
			File file=new File("C:\\C376\\abc.txt");
			FileInputStream fis=new FileInputStream(file);
			String insert = "insert into blobdemo1(emp_id,photo) values (?, ?)";
			PreparedStatement ps=con.prepareStatement(insert);
			ps.setInt(1, 10);
//			ps.setBinaryStream(2, fis);
			ps.setBinaryStream(2, fis, (int)file.length());
//			ps.executeUpdate();
			
			
			String select="select * from blobdemo1;";
			Statement stat = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			ResultSet rs=stat.executeQuery(select);
			while(rs.next()) {
				int id=rs.getInt("emp_id");
				Object pic=rs.getObject("photo");
				System.out.println(id+" "+pic);
				
			}
			
			
		} catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
	}

}
