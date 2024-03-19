package com.wileyedge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wileyedge.dao.EmployeeDao;
import com.wileyedge.dao.IDao;
import com.wileyedge.model.Employee;

@Service(value="service")
public class EmployeeService implements IService {

	@Autowired
	private IDao dao;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Transactional(propagation = Propagation.REQUIRED )
	public void saveEmployees(List<Employee> empList) {
//		System.out.println("Inside Service Layer");
		for(Employee e:empList) {
			dao.saveEmployee(e);
		}
	}

	public void modifyEmployees(List<Employee> empList) {
		for(Employee e:empList) {
			dao.modifyEmployee(e);
		}
	}

}
