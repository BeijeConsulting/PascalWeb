package it.beije.pascal.domus;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import it.beije.pascal.domus.enums.TipoAnnuncio;
import it.beije.pascal.domus.exception.RegistrationException;

import javax.persistence.Query;


public class DomusJPA {

	public DomusJPA() {
	}
	
	public Utente getUtenteFromId(int id) {
		EntityManager em = EntityManagerProvider.getEntityManager();
		Utente utente = em.find(Utente.class, em);
		em.close();
		return utente;
	}
	
	public static void insertUtente(Utente utente) throws RegistrationException {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM Utente as u");
		List<Utente> utenti = query.getResultList();
		boolean exist = false;
		for (Utente u : utenti) {
			if (u.getEmail().equals(utente.getEmail()))
				exist = true;
		}
		if (!exist) {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(utente);
			transaction.commit();
			entityManager.close();
		} else {
			throw new RegistrationException("Email already in use");
		}
	}

	public static Utente login(String email, String password) {
		EntityManager em = EntityManagerProvider.getEntityManager();
		String qlString = "select u from Utente as u where u.email = :email and u.password = :password";
		TypedQuery<Utente> query = em.createQuery(qlString, Utente.class);
		query.setParameter("password", password).setParameter("email", email);
		Utente utente = query.getSingleResult();
		em.close();
		return utente;
	}
	
	public static void insertAnnuncio(Annuncio annuncio) {
		EntityManager em = EntityManagerProvider.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		et.begin();
		em.persist(annuncio);
		et.commit();
		
		em.close();
	}
	
	public static void insertIndirizzo(Indirizzo indirizzo) {
		EntityManager em = EntityManagerProvider.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(indirizzo);
		et.commit();
		em.close();

	}
	
}
