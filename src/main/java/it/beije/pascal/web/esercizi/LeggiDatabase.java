package it.beije.pascal.web.esercizi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


/**
 * Servlet implementation class LeggiDatabase
 */
@WebServlet("/LeggiDatabase")
public class LeggiDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		
		List<Contatto> contatti = query.getResultList();
		
		String cognome = request.getParameter("cognome");
		
		HttpSession sessione = inviaSessione(contatti, cognome, request);

//		StringBuilder sb = new StringBuilder();
//		for (Contatto c : contatti) {
//			if(c.getCognome().equals(cognome)) {
//				sb.append(c);
//				sb.append('\n');
//			}
//		}
//
//		response.getWriter().append(sb);
		
		response.sendRedirect("mostraContatti.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static HttpSession inviaSessione(List<Contatto> contatti, String cognome, HttpServletRequest request) {
		List<Contatto> contacts = new ArrayList<Contatto>();
		for(Contatto c : contatti) {
			if(c.getCognome().equalsIgnoreCase(cognome)) {
				contacts.add(c);
			}
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("contatti", contacts);
		
		return session;
	}

}
