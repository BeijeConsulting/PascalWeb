package it.beije.pascal.web;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.domus.DomusJPA;
import it.beije.pascal.domus.GestioneUtente;
import it.beije.pascal.domus.Utente;
import it.beije.pascal.domus.enums.TipoAnnuncio;
import it.beije.pascal.domus.enums.*;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/domus/domus_login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		
		Utente utente = null;
		try {
		utente = DomusJPA.login(email, password);
		System.out.println("loggato da db: " + utente);
		}catch(NoResultException e) {
			request.getSession().setAttribute("error", "LOGIN_FAILED");
			return;
		}
		if(utente ==null) {
			request.getSession().setAttribute("error", "LOGIN_FAILED");
		}
		else {
			request.getSession().setAttribute("logged_user", utente);
			System.out.println("inserito in sessione: " + request.getSession().getAttribute("logged_user").toString());
		}
		response.sendRedirect("domus_home.jsp");
		doGet(request, response);
	}
	
	

}
