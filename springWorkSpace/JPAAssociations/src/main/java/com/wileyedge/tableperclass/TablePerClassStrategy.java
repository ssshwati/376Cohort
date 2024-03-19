package com.wileyedge.tableperclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import com.wileyedge.utility.EntityManagerHelper;

public class TablePerClassStrategy {

	public static void main(String[] args) {
		EntityManager em= EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		Employee e1=new PermanentEmployee("Ayush","Arbat",1);
		Employee e2=new PermanentEmployee("Yash","Mahajan",2);
		Employee e3=new ContractEmployee("Ujwal","Ubhad" , "WileyEdge");
		Employee e4=new ContractEmployee("Swaraj", "Balinge", "WileyEdge");
		tx.begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		tx.commit();
		
	}

}
