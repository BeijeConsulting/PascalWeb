package it.beije.pascal.immobiliareenums;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.immobiliare.Utente;
import it.beije.pascal.immobiliare.Util;

/**
 * Servlet implementation class immobiliareServlet
 */
@WebServlet("/immobiliareServlet")
public class immobiliareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Util util = Util.getInstance();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public immobiliareServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("Login") != null) {
			System.out.println("Login");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(email + " " +password);
			Utente u = util.SearchUser(email,password);
			
			System.out.println(u);
			if(u == null)
				System.out.println("nessuna persona con questa mail");
			else
			{
				System.out.println(u);
				request.getSession().setAttribute("utente", u);
				response.sendRedirect("immobiliareHome.jsp");
			}
		}

		if (request.getParameter("Registrazione") != null) {
			System.out.println("Registrazione");

			response.sendRedirect("registrazione.jsp");

			Utente newUtente = new Utente();

		}

		if (request.getParameter("newUtente") != null) {
			System.out.println("Nuovo Utente");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String avatar = request.getParameter("avatarUrl");
			String spamCheck = request.getParameter("spam_check"); // boolean
			String username = request.getParameter("username");

			System.out.println(email + " " + password + " " + avatar + " " + spamCheck + " " + username);

			Timestamp sqlTimestamp = new Timestamp(System.currentTimeMillis());

			Utente newUtente = new Utente(email, avatar, password, false, false, username, sqlTimestamp);

			util.insertNewUtente(newUtente);			
			
			response.sendRedirect("login.jsp");

		}

	}

}
