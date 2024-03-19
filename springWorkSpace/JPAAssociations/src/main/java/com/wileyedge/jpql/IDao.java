package com.wileyedge.jpql;

import java.util.List;

public interface IDao {
	void createEmployee(String fname, String lname);	public List<Employee> getEmployees();
	public List<Employee> getEmployeesWithIdGrX(int x);
	public List<String> getEmployeeNames();
	public List<Employee> getXEmployees(int startindex, int number);
	public List<Employee> getEmployeesUsingNamedQuery();	
	public List<Employee> getEmployeesUsingNativeNamedQuery();
	public void displayEmployeesByIdFnameUsingCriteria(int id, String fname);
}
