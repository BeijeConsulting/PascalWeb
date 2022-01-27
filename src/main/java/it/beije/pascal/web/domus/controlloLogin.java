package it.beije.pascal.web.domus;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.pascal.web.beans.Utente;

/**
 * Servlet implementation class controlloLogin
 */
@WebServlet("/controlloLogin")
public class controlloLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("loginDomus.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Configuration conf = new Configuration().configure().addAnnotatedClass(Utente.class);
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query<Utente> query = session.createQuery("SELECT u FROM Utente as u");
		List<Utente> utenti = query.getResultList();

		boolean esiste = false;
		Utente user = new Utente();
		for (Utente u : utenti) {
			if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)) {
				user = u;
				esiste = true;
			}
		}
		if (esiste) {
			request.getSession().setAttribute("loggedUser", user);
			response.sendRedirect("paginaAccesso.jsp");
		} else {
			request.getSession().setAttribute("error", "CREDENZIALI ERRATE");
			response.sendRedirect("loginDomus.jsp");
		}

	}

}
