package it.beije.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.domus.Utente;

public class ManagerJPA {

	
	public static List<Utente> getUtenti(){
		
		
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		Query query = entityManager.createQuery("SELECT c FROM Utenti as c");
		
		List<Utente> elenco = query.getResultList();
		
		entityManager.close();
		return elenco;
		
	}
	
	public static void addUser(Utente u) {
		
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(u);
		transaction.commit();
		entityManager.close();
		
	}
	
}
