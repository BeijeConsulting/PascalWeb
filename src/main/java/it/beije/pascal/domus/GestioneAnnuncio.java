package it.beije.pascal.domus;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GestioneAnnuncio {
	
	public static List<Annuncio> cercaAnnunci(String tipoImmobile, String tipoAnnuncio, String localita) {
		String jpql = "SELECT a,i FROM Annuncio JOIN Indirizzo AS a,i\n"
				+ "ON annuncio.indirizzo_id = indirizzo.id\n"
				+ "WHERE tipo_immobile = :tipo_immobile AND tipo_annuncio = :tipo_annuncio AND comune = :comune";
		System.out.println(jpql);
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		Query query = entityManager.createQuery(jpql);
		query.setParameter("tipo_immobile", tipoImmobile);
		query.setParameter("tipo_annuncio", tipoAnnuncio);
		query.setParameter("localita", localita);
		List<Annuncio> annunci = query.getResultList();
		entityManager.close();
		return annunci;
	}

}
