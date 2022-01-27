package it.beije.pascal.web.domus;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.beije.pascal.web.beans.Utente;

/**
 * Servlet implementation class registraNuovoUtente
 */
@WebServlet("/registraNuovoUtente")
public class registraNuovoUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("registrazione.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// JPA non funziona non so perchè!!!!
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pippo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Utente newUtente = new Utente();
		newUtente.setEmail(email);
		newUtente.setPassword(password);
		newUtente.setAmministratore(false);
		newUtente.setSpamCheck(false);
		entityManager.persist(newUtente);
		
		transaction.commit();
		entityManager.close();

		
		// Anche con Hibernate nope!!!
//		Configuration configuration = new Configuration().configure().addAnnotatedClass(Utente.class);
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		Utente newUtente = new Utente();
//		newUtente.setEmail(email);
//		newUtente.setPassword(password);
//		newUtente.setAmministratore(false);
//		newUtente.setSpamCheck(false);
//		session.save(newUtente);
//		transaction.commit();
//		session.close();
		
		request.getSession().setAttribute("loggedUser", newUtente);
		response.sendRedirect("paginaAccesso.jsp");
	}

}
