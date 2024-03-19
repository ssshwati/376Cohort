package com.wileyedge.dao;

import java.util.List;

import com.wileyedge.model.Employee;

public interface IDao {
	int createEmployee(int id, String fname, String lname);
	boolean updateEmployee(int id, String newfname);
	boolean removeEmployee(int id);
	public List<Employee> getEmployees();
}
