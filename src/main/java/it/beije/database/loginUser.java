package it.beije.database;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.domus.Utente;

/**
 * Servlet implementation class loginUser
 */
@WebServlet("/loginUser")
public class loginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("login_user.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user_name");
		String password = request.getParameter("pass_word");
		System.out.println("user_name : " + username);
		System.out.println("pass_word : " + password);
		
		Utente u = ManagerJPA.searchUser(username, password);
		
		System.out.println("Hey, questo è quello che hai cercato: "+u);
		
		if(u != null) {			
			request.getSession().setAttribute("loggedUser", u);
			response.sendRedirect("pages/personal_page.jsp");
			
		} else {
			request.getSession().setAttribute("error", "CREDENZIALI ERRATE!!!");
			response.sendRedirect("pages/login_user.jsp");
		}
		
		
	}

}
