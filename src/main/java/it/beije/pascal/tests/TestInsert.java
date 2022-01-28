package it.beije.pascal.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.pascal.bean.Utente;
import it.beije.pascal.database.EntityManagerProvider;

public class TestInsert {
	EntityManager entityManager = EntityManagerProvider.getEntityManager();
	
	public static boolean inserisciUtente(Utente u) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		Query query = entityManager.createQuery("SELECT u FROM Utente as u");
		List<Utente> utenti = query.getResultList();
		boolean esiste = false;
		if(!utenti.isEmpty()) {
		for (Utente ut : utenti) {
			if (ut.getEmail().equals(u.getEmail()))
				esiste = true;
		}
		
		}
		
		if (!esiste ){
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(u);
			transaction.commit();
			entityManager.close();
		}
		
		return esiste;
	}
	
	
}
