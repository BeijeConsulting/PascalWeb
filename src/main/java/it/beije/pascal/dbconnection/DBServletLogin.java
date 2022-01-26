package it.beije.pascal.dbconnection;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.bean.Utente;

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/dblogin")
public class DBServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Utente u = DomusJPAManager.cercaUtente(email, password);

		if (u != null) {
			request.getSession().setAttribute("loggedUser", u);
			response.sendRedirect("home.jsp");
		} else {
			request.getSession().setAttribute("error", "CREDENZIALI ERRATE!!!");
			response.sendRedirect("logindomus.jsp");
		};
	}

}
