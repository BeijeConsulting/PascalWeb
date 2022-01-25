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



@WebServlet("/contatti")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Session getSession() {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);	
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		return session;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Hibernate
		Session session = getSession();
		
		@SuppressWarnings("unchecked")
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		List<Contatto> contatti = query.getResultList();
		
		StringBuilder s = new StringBuilder();
		
		for(Contatto c : contatti) {
			s.append("<div><h1>"+c.getNome() + " " + c.getCognome() + "</h1>")
			.append("<p>" + " contatto n° " + c.getId() + "<br />" + "numero di telefono: " + c.getTelefono() + "<br />" + "email: " + c.getEmail() + "<br />" + "note: " +c.getNote() + "</p></div>");
		}
	
		session.close();
		
		response.getWriter().append(s);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String note = request.getParameter("notes");
		
		Contatto contatto = new Contatto();
		contatto.setNome(fname);
		contatto.setCognome(lname);
		contatto.setTelefono(tel);
		contatto.setEmail(email);
		contatto.setNote(note);
		
		Session session = getSession();
		session.save(contatto);
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		session.save(contatto);
		transaction.commit();
		
		session.close();
		
		response.getWriter().append("fname: ").append(fname).append(", lname: ").append(lname)
		.append("tel: " + tel).append(", email: " + email).append(", note: " + note);		
	}
}
