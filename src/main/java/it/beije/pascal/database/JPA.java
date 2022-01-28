package it.beije.pascal.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.pascal.bean.*;

public class JPA {
	
	public static Utente login(String email, String password){
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
	
	public static List<Annuncio> cercaAnnunci(String tipoImmobile, String tipoAnnuncio, Integer prezzo, Integer mq, Integer locali, Integer bagni, Integer totPiani, Integer piano, Boolean ascensore, Integer postiAuto, Boolean balcone, Boolean terrazzo, String giardino, String condizione, String classeEnergetica, String riscaldamento, String ariaCondizionata, String arredamento, 
			                                   Boolean piscina, Boolean portineria, Integer  annoCostruzione, String statoRogito, Boolean visitaGuidata, String descrizione, Boolean virtualTour){
		
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		Query query = entityManager.createQuery("SELECT a FROM Annuncio as a WHERE  tipo_immbile = '" + tipoImmobile
				                                                       + "' AND tipo_annuncio = '" + tipoAnnuncio 
				                                                       + "' AND prezzo = '" + prezzo 
				                                                       + "' AND mq = '" + mq 
				                                                       + "' AND locali = '" + locali 
				                                                       + "' AND bagni = '" + bagni 
				                                                       + "' AND tot_piani = '" + totPiani
				                                                       + "' AND piano = '" + piano
				                                                       + "' AND ascensore = '" + ascensore
				                                                       + "' AND posti_auto = '" + postiAuto
				                                                       + "' AND balcone = '" + balcone
				                                                       + "' AND terrazzo = '" + terrazzo
				                                                       + "' AND giardino = '" + giardino
				                                                       + "' AND condizione = '" + condizione
				                                                       + "' AND classe_energetica = '" + classeEnergetica
				                                                       + "' AND riscaldamento = '" + riscaldamento
				                                                       + "' AND aria_condizionata = '" + ariaCondizionata
				                                                       + "' AND arredamento = '" + arredamento
				                                                       + "' AND piscina = '" + piscina
				                                                       + "' AND portineria = '" + portineria
				                                                       + "' AND anno_costruzione = '" + annoCostruzione
				                                                       + "' AND stato_rogito = '" + statoRogito
				                                                       + "' AND visita_guidata = '" + visitaGuidata
				                                                       + "' AND descrizione_lunga = '" + descrizione
				                                                       + "' AND virtual_tour = '" + virtualTour + "'");
		
		List<Annuncio> annunci = query.getResultList();;
		
		return annunci;
	}
	
	public static boolean inserisciUtente(Utente u) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		Query query = entityManager.createQuery("SELECT u FROM Utente as u");
		List<Utente> utenti = query.getResultList();
		
		boolean esiste = false;
		for (Utente ut : utenti) {
			if (ut.getEmail().equals(u.getEmail()))
				esiste = true;
		}
		
		if (!esiste) {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(u);
			transaction.commit();
			entityManager.close();
		}
		
		return esiste;
	}
	
	public static void inserisciAnnuncio(Annuncio a) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(a);
		
		transaction.commit();
		entityManager.close();
	}
	
	public static void inserisciCommerciale(Commerciale c) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(c);
		
		transaction.commit();
		entityManager.close();
	}
	
	public static void inserisciIndirizzo(Indirizzo i) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(i);
		
		transaction.commit();
		entityManager.close();
	}
	
	public static void inserisciRicerca(Ricerca r) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(r);
		
		transaction.commit();
		entityManager.close();
	}
	
	public static void inserisciFoto(Foto f) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(f);
		
		transaction.commit();
		entityManager.close();
	}
	
	public static void inserisciAnnunciSalvati(AnnunciSalvati a) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(a);
		
		transaction.commit();
		entityManager.close();
	}

}
