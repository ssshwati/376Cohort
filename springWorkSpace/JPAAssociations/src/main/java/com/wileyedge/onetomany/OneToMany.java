package com.wileyedge.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.utility.EntityManagerHelper;

public class OneToMany {

	public static void main(String[] args) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx= em.getTransaction();
//		tx.begin();
		Employee e1=new Employee("Shwati","Kumari");
		Employee e2=new Employee("Shweta","Kumari");
		Employee e3=new Employee("Harsh","Kankane");
		List<Employee> list1=new ArrayList<Employee>();
		list1.add(e1);
		list1.add(e2);
		list1.add(e3);
		Department d1=new Department("Java_Department");
		d1.setEmployees(list1);
		
		List<Employee> list2=new ArrayList<Employee>();
		list2.add(new Employee("Aditya","Raj"));
		list2.add(new Employee("Ankit","Raj"));
		Department d2=new Department("Python_department");
		d2.setEmployees(list2);
		
		
		tx.begin();
		em.persist(d1);
		em.persist(d2);
		em.persist(e1);
		em.persist(e2);
		
		tx.commit();
	}

}
