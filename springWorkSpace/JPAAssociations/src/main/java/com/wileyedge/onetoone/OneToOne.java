package com.wileyedge.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.utility.EntityManagerHelper;

public class OneToOne {

	public static void main(String[] args) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		Address a=new Address("Amravati","440013");
		em.persist(a);
		Employee e=new Employee("Yash","Mahajan");
		e.setAddr(a);
		em.persist(e);
		tx.commit();
	}

}
