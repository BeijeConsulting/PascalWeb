package it.beije.pascal.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/modifica")
public class Modifica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("nome");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		
		HttpSession session = request.getSession();
		session.setAttribute("nome", nome);
		session.setAttribute("cognome", cognome);
		session.setAttribute("tel", tel);
		session.setAttribute("email", email);
		session.setAttribute("note", note);
		
		response.sendRedirect("form_modifica.jsp");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
