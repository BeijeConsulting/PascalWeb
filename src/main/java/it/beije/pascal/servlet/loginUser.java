package it.beije.pascal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.beije.pascal.bean.Utente;
import it.beije.pascal.database.ManagerJPA;
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
		
		response.sendRedirect("pages/login_user.jsp");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("pass_word");
		System.out.println("email : " + email);
		System.out.println("pass_word : " + password);
		
		Utente u = ManagerJPA.searchUser(email, password);
		
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
