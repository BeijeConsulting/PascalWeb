package it.beije.pascal.immobiliare;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Util {

	private static Util util = null;

	private Util() {
	}

	public static Util getInstance() {
		if (util == null)
			util = new Util();

		return util;
	}

	private static EntityManagerFactory entityManagerFactory = null;

	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("pascal-rubrica");
		}

		return entityManagerFactory.createEntityManager();
	}

	public Utente SearchUser(String email, String password) {
		EntityManager entityManager = getEntityManager();

		Query query = entityManager.createQuery("SELECT c FROM Utente as c WHERE c.email = '" + email + "'" +
				  " and c.password = '" + password + "'");
		
		List<Utente> utenti = query.getResultList();

		if (utenti.size() != 0)
			return utenti.get(0);
		else
			return null;
	}

	public void insertNewUtente(Utente newUtente) {

		EntityManager entityManager = getEntityManager();

		Query query = entityManager.createQuery("SELECT u FROM Utente as u");
		List<Utente> utenti = query.getResultList();

		boolean exist = false;

		for (Utente utente : utenti) {
			if (utente.getEmail().equals(newUtente.getEmail()))
				exist = true;
		}

		if (!exist) {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(newUtente);
			transaction.commit();
			entityManager.close();
		} else {
			System.out.println("già presente");
		}
	}
	
	public static List<Annuncio> allAnnunci() {

		EntityManager entityManager = getEntityManager();

		Query query = entityManager.createQuery("SELECT a FROM Annuncio as a");
		List<Annuncio> annunci = query.getResultList();

		return annunci;
	}

}
