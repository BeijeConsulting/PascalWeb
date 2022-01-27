package it.beije.pascal.database;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.pascal.bean.Commerciale;
import it.beije.pascal.bean.Utente;

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

	public static Utente searchUser(String email, String psw) {

		EntityManager entityManager = EntityManagerProvider.getEntityManager();

		Query query = entityManager.createQuery(
				"SELECT c FROM Utente as c WHERE c.email = '" + email + "'" + " and c.password = '" + psw + "'");

		Utente utente = (Utente) query.getSingleResult();
		entityManager.close();

		System.out.println("Hey, questo è quello che hai cercato: " + utente);

		return utente;

	}

}
