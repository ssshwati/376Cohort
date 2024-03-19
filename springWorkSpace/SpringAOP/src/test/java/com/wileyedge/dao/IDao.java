package com.wileyedge.dao;

import java.util.List;

import com.wileyedge.model.Employee;

public interface IDao {
	public void saveEmployee(Employee e);
	public void modifyEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int empid);
	
	public String getEmployeeNameById(int empid);
	
	int getEmployeeCount();
}
