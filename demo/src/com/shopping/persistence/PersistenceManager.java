package com.shopping.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class PersistenceManager {

	private static String PERSISTENCE_NAME = "demoUnit";

	private static EntityManagerFactory emFactory;

	public static synchronized EntityManager getEntityManager() {
		if (emFactory == null) {
			emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
		}
		EntityManager em = emFactory.createEntityManager();
		return em;
	}
}
