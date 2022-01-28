package it.beije.pascal.web;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.domus.DomusJPA;
import it.beije.pascal.domus.EntityManagerProvider;
import it.beije.pascal.domus.GestioneUtente;
import it.beije.pascal.domus.Utente;
import it.beije.pascal.domus.exception.RegistrationException;


@WebServlet("/register_user")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		boolean spamCheck = request.getParameter("spam_check")!=null &&((String)request.getParameter("spam_check")).equals("on");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		//test
		System.out.println("dati utente: "+email+ " "+password+" "+spamCheck);
		
		Utente utente = GestioneUtente.createUser(email, null, password, spamCheck, false);
		utente.setTimeStamp(ts);
		try {
			DomusJPA.insertUtente(utente);
		} catch (RegistrationException e) {
			request.getSession().setAttribute("error", e.getMessage());
		}		
		response.sendRedirect("domus_login.html");
	}
}
