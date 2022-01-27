package it.beije.database;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.domus.Utente;

/**
 * Servlet implementation class DBservlet
 */
@WebServlet("/register")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("pages/sign_in.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user_name");
		String email = request.getParameter("email");
		String password = request.getParameter("pass_word");
		System.out.println("user_name : " + username);
		System.out.println("pass_word : " + password);
		System.out.println("pass_word : " + email);

		Utente u = new Utente();
		
		u.setEmail(email);
		u.setUsername(username);
		u.setPassword(password);
		
		ManagerJPA.addUser(u);
		
		System.out.println(u);
		System.out.println("utente aggiunto con successo");
		
		response.sendRedirect("index.html");
		
	}

}
