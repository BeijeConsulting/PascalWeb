package it.beije.pascal.domus;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class DomusJPA {

	public DomusJPA() {
	}
	
	public Utente getUtenteFromId(int id) {
		EntityManager em = EntityManagerProvider.getEntityManager();
		Utente utente = em.find(Utente.class, em);
		em.close();
		return utente;
	}
	
	public void InsertUtente(Utente utente) {
		EntityManager em = EntityManagerProvider.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(utente);
		et.commit();
		
		em.close();
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
	
}
