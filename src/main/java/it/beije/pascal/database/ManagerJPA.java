package it.beije.pascal.database;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import it.beije.pascal.bean.Annuncio;
import it.beije.pascal.bean.Commerciale;
import it.beije.pascal.bean.Indirizzo;
import it.beije.pascal.bean.Utente;
import it.beije.pascal.bean.enums.TipoImmobile;

public class ManagerJPA {

	public static List<Utente> getUtenti() {

		EntityManager entityManager = EntityManagerProvider.getEntityManager();

		Query query = entityManager.createQuery("SELECT c FROM Utente as c");

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

	public static void addcommercial(Commerciale c) {

		EntityManager entityManager = EntityManagerProvider.getEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(c);
		transaction.commit();
		entityManager.close();

	}
	
	public static void addAddress(Indirizzo i) {

		EntityManager entityManager = EntityManagerProvider.getEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(i);
		transaction.commit();
		entityManager.close();

	}
	
	public static void addAdvertisement(Annuncio a) {

		EntityManager entityManager = EntityManagerProvider.getEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(a);
		transaction.commit();
		entityManager.close();

	}

	public static Utente searchUser(String email, String psw) {

		EntityManager entityManager = EntityManagerProvider.getEntityManager();

		Utente utente;
		Query query = null;
		try {
			query = entityManager.createQuery(
					"SELECT c FROM Utente as c WHERE c.email = '" + email + "'" + " and c.password = '" + psw + "'");
			utente = (Utente) query.getSingleResult();
		} catch (NoResultException e) {
			utente = null;
		}
		
		entityManager.close();

		return utente;

	}
	
	public static Annuncio searchAdvertisement(TipoImmobile tipoImmobile) {

		EntityManager entityManager = EntityManagerProvider.getEntityManager();

		Annuncio annuncio;
		Query query = null;
		try {
			query = entityManager.createQuery(
					"SELECT a FROM Annuncio as a WHERE tipo_immobile = '" + tipoImmobile + "'");
			annuncio = (Annuncio) query.getSingleResult();
		} catch (NoResultException e) {
			annuncio = null;
		}
		
		entityManager.close();

		return annuncio;

	}
	
	public static List<Annuncio> getAds(){
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		List<Annuncio> listann = new ArrayList<>();
		Query query= null;
		try {
			query = entityManager.createQuery("Select a from Annuncio as a");
			listann = query.getResultList();
			
			
		}catch(Exception e) {
			System.out.println("Errore lista annunci: getAds()");
		}
		
		entityManager.close();
		return listann;
	}
	
	public static Indirizzo getAddress(int id) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		Indirizzo address = entityManager.find(Indirizzo.class, id);
		return address;	
	}
	
	public static Annuncio getAnnuncio(int id) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		Annuncio annuncio = entityManager.find(Annuncio.class, id);
		return annuncio;	
	}

	

}
