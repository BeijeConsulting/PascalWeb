package it.beije.pascal.web;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.domus.EntityManagerProvider;
import it.beije.pascal.domus.GestioneUtente;
import it.beije.pascal.domus.Utente;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/domus/register_user")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		boolean spamCheck = request.getParameter("spam_check").equals("on");
		
		//test
		System.out.println("dati utente: "+email+ " "+password+" "+spamCheck);
		
		Utente utente = GestioneUtente.createUser(email, null, password, spamCheck, false);
		GestioneUtente.addUser(utente);
		
		
	}

}
