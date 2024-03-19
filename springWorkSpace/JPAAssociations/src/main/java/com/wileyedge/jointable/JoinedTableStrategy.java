package com.wileyedge.jointable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import com.wileyedge.utility.EntityManagerHelper;

public class JoinedTableStrategy {

	public static void main(String[] args) {
		EntityManager em= EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		Employee e1=new PermanentEmployee("Ankit","Raj",1);
		Employee e2=new PermanentEmployee("Aditya","Raj",2);
		Employee e3=new ContractEmployee("Shweta","Kumari" , "WileyEdge");
		Employee e4=new ContractEmployee("Shwati", "Kumari", "WileyEdge");
		tx.begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		tx.commit();
	}

}
