package it.beije.pascal.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ci prendiamo i parametri passati con il form
		String username = request.getParameter("user_name");
		String password = request.getParameter("pass_word");
		System.out.println("user_name : " + username);
		System.out.println("pass_word : " + password);

		//facciamo un controllo su username e password e nel caso
		if (username.equals("Pippo") && password.equals("123456")) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);

			//alla sessione gli passiamo il Bean user creato chiamandolo come "loggedUser"
			request.getSession().setAttribute("loggedUser", user);
			//e andiamo alla pagina homepage.jsp
			response.sendRedirect("homepage.jsp");
		} else {
			//se username e password non sono rispettati allora in sessione creiamo una Stringa error
			request.getSession().setAttribute("error", "CREDENZIALI ERRATE!!!");
			response.sendRedirect("login.jsp");
		}

	}

}
