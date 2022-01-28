package it.beije.pascal.tests;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.web.User;

/**
 * Servlet implementation class TestLogin
 */
@WebServlet("/testlogin")
public class TestLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user_name");
		String password = request.getParameter("pass_word");
		System.out.println("user_name : " + username);
		System.out.println("pass_word : " + password);

		if (username.equals("Pippo") && password.equals("123456")) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			
			request.getSession().setAttribute("loggedUser", user);
			response.sendRedirect("homepage.jsp");
		} else {
			request.getSession().setAttribute("error", "CREDENZIALI ERRATE!!!");
			response.sendRedirect("login.jsp");
		}
		
	}

}