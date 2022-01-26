package it.beije.pascal.dbconnection;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.pascal.bean.Utente;

public class DomusJPAManager {
	
	public static Utente cercaUtente(String email, String password){
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		Query query = entityManager.createQuery("SELECT u FROM Utente as u WHERE  email = '" + email
				                                                       + "' AND password = '" + password + "'");
		
		Utente risultato = null;
		
		List<Utente> appoggio = query.getResultList();
		if(appoggio.size() != 0) {
			risultato = appoggio.get(0);
		}
		
		entityManager.close();
		return risultato;
	}
	
	public static void inserisciUtente(Utente u) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(u);
		
		transaction.commit();
		entityManager.close();
	}

}
