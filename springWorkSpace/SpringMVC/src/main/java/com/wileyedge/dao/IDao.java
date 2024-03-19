package com.wileyedge.dao;

import java.util.List;

import com.wileyedge.model.Employee;

public interface IDao {
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int empid);
		
	public String getEmployeeNameById(int empid);
		
	int getEmployeeCount();
	public void saveEmployee(Employee emp);
	public void modifyEmployee(Employee emp);
}
