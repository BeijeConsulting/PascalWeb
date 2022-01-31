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
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
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

		Utente u = ManagerJPA.searchUser(email, password);
		

		if(u != null) {		
			if(u.isAmministratore()) {
				request.getSession().setAttribute("loggedUser", u);
				response.sendRedirect("pages/personal_page_admin.jsp");
			}
			else {
				request.getSession().setAttribute("loggedUser", u);
				response.sendRedirect("pages/personal_page.jsp");
			}

			
		} else {
			request.getSession().setAttribute("error", "CREDENZIALI ERRATE!!!");
			response.sendRedirect("pages/login_user.jsp");
		}
		
		
	}
}
