package com.wileyEdge.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCDemo1 {

	public static MysqlDataSource getDataSource() throws SQLException {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setDatabaseName("empmgmt");
		ds.setUser("root");
		ds.setPassword("root");
		ds.setServerTimezone("America/Chicago");
//		Server Timezone helps the server know how to handle dates and times correctly.
		ds.setUseSSL(false);
//		Use SSL toggles SSL encryption. We would typically set this to true, but for our local development, 
//		it would be overkill to set up the infrastructure. We default to false for this activity.	
		ds.setAllowPublicKeyRetrieval(true);
//		Allow Public Key Retrieval allows our JDBC driver to send the password to our database securely.
		return ds;
	}

	public static void displayRecords() throws SQLException {
		String select = "select * from dept";
		Connection con = getDataSource().getConnection();
//		System.out.println(con);
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery(select);
		ResultSetMetaData rsm = rs.getMetaData();
		System.out.println(rsm.getColumnName(1) + "\t" + rsm.getColumnName(2) + "\t\t" + rsm.getColumnName(3));
		while (rs.next()) {
			int id = rs.getInt("deptid");
			String name = rs.getString("dname");
			String city = rs.getString("loc");
			System.out.println(id + "\t" + name + "\t\t" + city);
		}
	}

	public static void insertRecords(int did, String dname, String loc) throws SQLException {
		Connection con = getDataSource().getConnection();
		Statement stat = con.createStatement();
//		String insert = "insert into dept values(70,'Tech','Bangalore')";
		PreparedStatement pstat = con.prepareStatement("INSERT INTO DEPT(DEPTID,DNAME,LOC) VALUES(?,?,?);");
//		?  = PLACEHOLDER
		pstat.setInt(1, did);
		pstat.setString(2, dname);
		pstat.setString(3, loc);
		int n = pstat.executeUpdate();
		System.out.println(n + " rows inserted");
	}

	public static void updateRecords(int id, String loc) throws SQLException {
		Connection con = getDataSource().getConnection();
		String update = "UPDATE DEPT SET loc = ? where deptid = ?";
		PreparedStatement pstat1 = con.prepareStatement(update);
		pstat1.setString(1, loc);
		pstat1.setInt(2, id);
		int n = pstat1.executeUpdate();
		System.out.println(n + " rows updated");
	}

	public static void deleteRecords(int id) throws SQLException {
		Connection con = getDataSource().getConnection();
		String delete = "DELETE FROM DEPT WHERE deptid = ?";
		PreparedStatement pstat = con.prepareStatement(delete);
		pstat.setInt(1, id);
		int n = pstat.executeUpdate();
		System.out.println(n + " rows deleted");
	}

	public static void main(String[] args) {
		try {
//			insertRecords(80,"HR","Purnea");
			updateRecords(60, "Delhi");
			deleteRecords(80);
			displayRecords();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
