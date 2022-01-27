package it.beije.pascal.web.esercizi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.beije.pascal.web.esercizi.Contatto;

/**
 * Servlet implementation class AggiungiContatto
 */
@WebServlet("/AggiungiContatto")
public class AggiungiContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Servlet at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		
		Contatto newContatto = new Contatto();
		newContatto.setId(13);
		newContatto.setCognome(cognome);
		newContatto.setNome(nome);
		newContatto.setEmail(email);
		newContatto.setTelefono(telefono);
		newContatto.setNote(note);

		session.save(newContatto);
		
		HttpSession sessione = request.getSession();
		sessione.setAttribute("contatto", newContatto);

		transaction.commit();

		session.close();
		
		response.sendRedirect("leggiContatti.jsp");
//		response.getWriter().append("Il contatto " + newContatto + " è stato aggiunto").append(request.getContextPath());
	}

}
