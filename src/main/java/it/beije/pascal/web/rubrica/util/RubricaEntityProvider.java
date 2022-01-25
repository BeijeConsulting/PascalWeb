package it.beije.pascal.web.rubrica.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RubricaEntityProvider {
	
	private RubricaEntityProvider() {}
	
	private static EntityManagerFactory entityManagerFactory = null;
	
	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("rubrica");
		}
		
		return entityManagerFactory.createEntityManager();
	}

}
