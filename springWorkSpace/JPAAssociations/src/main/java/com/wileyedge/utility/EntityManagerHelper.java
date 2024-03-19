package com.wileyedge.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
	private static EntityManagerFactory factory;
	private EntityManager em;
	static {
		factory=Persistence.createEntityManagerFactory("jpaassociations");
	}
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
