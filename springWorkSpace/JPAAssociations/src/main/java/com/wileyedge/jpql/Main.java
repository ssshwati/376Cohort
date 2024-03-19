package com.wileyedge.jpql;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		IDao dao = new EmployeeDao();
		dao.createEmployee("Shwati", "Kumari");
		dao.createEmployee("Harsh","Kankane" );
		dao.createEmployee("Shweta","Kumari" );
		System.out.println("===================================");

		List<Employee> list1 = dao.getEmployees();
		list1.stream().forEach(System.out::println);
		System.out.println("===================================");
		
		List<Employee> list2 = dao.getEmployeesWithIdGrX(2);
		list2.stream().forEach(System.out::println);
		System.out.println("===================================");
		
		List<String> list3 = dao.getEmployeeNames();
		list3.stream().forEach(System.out::println);
		System.out.println("===================================");

		List<Employee> list4 = dao.getXEmployees(1,2);
		list4.stream().forEach(System.out::println);
		System.out.println("===================================");
		
		List<Employee> list5 = dao.getEmployeesUsingNamedQuery();
		list5.stream().forEach(System.out::println);
		System.out.println("===================================");
		
		List<Employee> list6 = dao.getEmployeesUsingNativeNamedQuery();
		list6.stream().forEach(System.out::println);
		System.out.println("===================================");
		
		dao.displayEmployeesByIdFnameUsingCriteria(2,"Harsh");
		System.out.println("===================================");

	}

}
