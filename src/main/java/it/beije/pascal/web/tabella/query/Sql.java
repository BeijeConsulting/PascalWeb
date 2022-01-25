package it.beije.pascal.web.tabella.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import it.beije.pascal.web.tabella.bean.Contatto;

public class Sql {
	
	private Sql() {
		
	}
	
	public static List<Contatto> findAll() {
		EntityManagerFactory entityManagereFactory = Persistence.createEntityManagerFactory("rubrica");
		EntityManager entityManager = entityManagereFactory.createEntityManager();
		String jpql = "SELECT c FROM Contatto AS c";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
		entityManager.close();
		return contatti;
	}
	
	public static void delete(int id) {
		String jpql = "SELECT c FROM Contatto AS c WHERE id = :id";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rubrica");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		Contatto contatto = (Contatto) query.getSingleResult();		
		entityManager.remove(contatto);
		transaction.commit();
		entityManager.close();
	}
	
	public static void update(Contatto contatto) {
		String jpql = "SELECT c FROM Contatto AS c WHERE id = :id";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rubrica");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", contatto.getId());
		
		Contatto vecchioContatto = (Contatto) query.getSingleResult();
		vecchioContatto.setNome(contatto.getNome());	
		vecchioContatto.setCognome(contatto.getCognome());
		vecchioContatto.setTelefono(contatto.getTelefono());
		vecchioContatto.setEmail(contatto.getEmail());
		vecchioContatto.setNote(contatto.getNote());
		
			
		entityManager.persist(vecchioContatto);
		transaction.commit();
		entityManager.close();
	}
	
	public static Contatto findById(int id) {
		String jpql = "SELECT c FROM Contatto AS c WHERE id = :id";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rubrica");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		Contatto contatto = (Contatto) query.getSingleResult();
		
		entityManager.persist(contatto);
		transaction.commit();
		entityManager.close();
		return contatto;
	}
	
	public static void save(Contatto contatto) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rubrica");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(contatto);
		transaction.commit();
		entityManager.close();
	}
}



























