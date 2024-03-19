package com.wileyedge.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.utility.EntityManagerHelper;

public class ManyToMany {

	public static void main(String[] args) {
		EntityManager em= EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		Employee e1=new Employee("Shwati","Kumari");
		Employee e2=new Employee("Shweta","Kumari");
		Employee e3=new Employee("Harsh","Kankane");
		
		TechSkill skill1=new TechSkill("Java");
		TechSkill skill2=new TechSkill("Python");
		List<Employee> javaemployees=new ArrayList<>();
		javaemployees.add(e1);
		javaemployees.add(e2);
		
		List<Employee> pythonemployees=new ArrayList<Employee>();
		pythonemployees.add(e2);
		pythonemployees.add(e3);
		
		skill1.setEmployees(javaemployees);
		skill2.setEmployees(pythonemployees);
		
		tx.begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(skill1);
		em.persist(skill2);

		
		tx.commit();
	}

}
