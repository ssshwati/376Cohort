package com.wileyedge.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wileyedge.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String fname = rs.getString("fname");
		String lname = rs.getString("lname");
		Employee e = new Employee(id,fname,lname);
		
		return e;
	}

}
