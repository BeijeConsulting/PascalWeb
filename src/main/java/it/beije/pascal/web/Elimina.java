package it.beije.pascal.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@WebServlet("/elimina")
public class Elimina extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private static Session getSession() {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);	
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		return session;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Hibernate
		Session session = getSession();
		
		@SuppressWarnings("unchecked")
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		int id = Integer.parseInt(request.getParameter("Id"));
		
		Contatto cont = null;
		
		for(Contatto c : contatti) {
			if(c.getId() == id) cont = c;
		}
		
		session.remove(cont);
		transaction.commit();
		
		session.close();
		
		response.sendRedirect("homepage.jsp");
	}

}
