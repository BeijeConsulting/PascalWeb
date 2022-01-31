package it.beije.pascal.domus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class GestioneAnnuncio {

	public static List<Annuncio> cercaAnnunci(String tipoImmobile, String tipoAnnuncio, String comune) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Annuncio> annunci = new ArrayList<Annuncio>();

		String sql = "SELECT annuncio.id,venditore_id,indirizzo_id,tipo_immobile,tipo_annuncio,mq,stato_rogito,visita_guidata,virtual_tour,create_timestamp \n"
				+ "FROM annuncio JOIN indirizzo \n" + "ON annuncio.indirizzo_id = indirizzo.id \n"
				+ "WHERE tipo_immobile = ? AND tipo_annuncio = ? AND comune = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = ConnectionManager.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, tipoImmobile);
			statement.setString(2, tipoAnnuncio);
			statement.setString(3, comune);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Annuncio annuncio = new Annuncio();
				annuncio.setId(resultSet.getInt("id"));
				annuncio.setVenditoriId(resultSet.getInt("venditore_id"));
				annuncio.setIndirizzoId(resultSet.getInt("indirizzo_id"));
				// annuncio.setTipoImmobile(resultSet.getString("tipo_immobile"));
				// annuncio.setTipoAnnuncio(resultSet.getString("tipo_annuncio"));
				annuncio.setMq(resultSet.getInt("mq"));
				// annuncio.setStatoRogito(resultSet.getString("stato_rogito"));
				annuncio.setVisitaGuidata(resultSet.getBoolean("visita_guidata"));
				annuncio.setVirtualTour(resultSet.getBoolean("virtual_tour"));
				annunci.add(annuncio);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return annunci;
	}

	public static List<Annuncio> findAll() {
		String jpql = "SELECT a FROM Annuncio AS a";
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		Query query = entityManager.createQuery(jpql);
		List<Annuncio> annunci = query.getResultList();
		entityManager.close();
		return annunci;

	}

	public static void delete(int id) {
		EntityManager entityManger = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManger.getTransaction();
		transaction.begin();
		// JPQL
		String jpql = "SELECT a FROM Annuncio AS a WHERE id = :id";
		Query query = entityManger.createQuery(jpql);
		query.setParameter("id", id);
		Annuncio annuncio = (Annuncio) query.getSingleResult();
		entityManger.remove(annuncio);
		transaction.commit();
		entityManger.close();

	}

	public static Indirizzo getIndirizzo(int id) {
		EntityManager entityManger = EntityManagerProvider.getEntityManager();
		Indirizzo ind = entityManger.find(Indirizzo.class, id);
		entityManger.close();
		return ind;
	}

	public static Annuncio getAnnuncio(int id) {
		EntityManager entityManger = EntityManagerProvider.getEntityManager();
		Annuncio and = entityManger.find(Annuncio.class, id);
		entityManger.close();
		return and;
	}

	public static void salvaAnnuncio(AnnunciSalvati annuncioSalvato) {
		EntityManager entityManger = EntityManagerProvider.getEntityManager();
		EntityTransaction transaction = entityManger.getTransaction();
		transaction.begin();
		entityManger.persist(annuncioSalvato);
		transaction.commit();
		entityManger.close();

	}

	public static List<Annuncio> getAnnunciSalvati(int utenteId) {
		System.out.println("dsnjadnajdnsaindsaknjdsaindasj    " + utenteId);
		EntityManager entityManger = EntityManagerProvider.getEntityManager();
		// JPQL

		// FIXME
		String jpql = "select a from Annuncio as a where a.id in (select s.annuncioId from AnnunciSalvati as s where s.utenteid = :utenteId)";
		Query query = entityManger.createQuery(jpql);
		query.setParameter("utenteId", utenteId); // Contatto contatto = (Contatto)
		query.getResultList().get(0);
		List<Annuncio> annunciSalvati = (List<Annuncio>) query.getResultList();
		entityManger.close();

		return annunciSalvati;
	}

}
