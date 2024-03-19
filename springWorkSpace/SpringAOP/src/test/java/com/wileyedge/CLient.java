package com.wileyedge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wileyedge.model.Employee;
import com.wileyedge.service.EmployeeService;
import com.wileyedge.service.IService;

public class CLient {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		IService service = context.getBean("service",IService.class);
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(10,"Shwati","Kumari"));
		empList.add(new Employee(20,"Harsh","Kankane"));
		service.saveEmployees(empList);
		service.modifyEmployees(empList);
	}

}
