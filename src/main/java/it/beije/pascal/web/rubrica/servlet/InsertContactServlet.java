package it.beije.pascal.web.rubrica.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.web.rubrica.bean.Contatto;
import it.beije.pascal.web.rubrica.util.RubricaEntityProvider;

@WebServlet("/InsertContactServlet")
public class InsertContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertContactServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ciao");
		PrintWriter writer = response.getWriter();
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		
		Contatto contatto = new Contatto(cognome, nome, telefono, email, note);
		save(contatto);
		writer.append("<p>Contatto salvato: " + contatto + "</p>");

	}

	private static void save(Contatto contatto) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rubrica");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.persist(contatto);
		transaction.commit();
		entityManager.close();
	}

}
