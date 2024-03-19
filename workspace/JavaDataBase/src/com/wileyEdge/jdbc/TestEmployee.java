package com.wileyEdge.jdbc;

public class TestEmployee {

	public static void main(String[] args) {
		try {
			Class.forName("com.wileyEdge.jdbc.Employee");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
