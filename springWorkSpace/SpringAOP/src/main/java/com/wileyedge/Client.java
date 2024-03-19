package com.wileyedge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wileyedge.dao.IDao;
import com.wileyedge.model.Employee;
import com.wileyedge.service.EmployeeService;
import com.wileyedge.service.IService;

public class Client {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("aop.xml");
		
		IService service = 
				context.getBean("service", IService.class);
		
		empList.add(new Employee(116,"Shwati","Kumari"));
		empList.add(new Employee(117,"Harshhhh","Kankane"));
		service.saveEmployees(empList);
//		service.modifyEmployees(empList);	
		
		IDao dao = context.getBean("dao",IDao.class);
		List<Employee> list = dao.getAllEmployees();
//		for(Employee e: list) {
//			System.out.println("---------------");
//			System.out.println(e);
//		}
//	
//		System.out.println("---------------");
//		Employee e = dao.getEmployeeById(10);
//		System.out.println(e);
//		
//		System.out.println("---------------");
//		System.out.println(dao.getEmployeeNameById(11));
//		
//		System.out.println("---------------");
//		System.out.println(dao.getEmployeeCount());
		
		
	}

}