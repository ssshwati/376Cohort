package com.wileyedge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wileyedge.dao.EmployeeDao;
import com.wileyedge.dao.IDao;
import com.wileyedge.model.Employee;

@Component(value = "service")
public class EmployeeService implements IService{
	@Autowired
	private IDao dao;
	public void saveEmployees(List<Employee> empList) {
//		System.out.println("inside service layer");
		for(Employee e : empList) {
			dao.saveEmployee(e);
		}
	}

	public void modifyEmployees(List<Employee> empList) {
		for(Employee e : empList) {
			dao.modifyEmployee(e);
		}
	}

}
