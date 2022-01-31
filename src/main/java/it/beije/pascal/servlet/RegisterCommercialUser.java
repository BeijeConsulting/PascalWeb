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
 * Servlet implementation class RegisterCommercialUser
 */
@WebServlet("/registerCommercialUser")
public class RegisterCommercialUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCommercialUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("pages/sign_in_cUser.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user_name");
		String email = request.getParameter("email");
		String password = request.getParameter("pass_word");
		String agenzia = request.getParameter("agenzia");
		String spam = request.getParameter("spam");
		boolean s = false;
		if(spam.equals("on"))
			s=true;
		
		int idAzienda = ManagerJPA.searchEstate(agenzia);
		
		Utente u = new Utente();
		if(idAzienda != 0) {
			u.setEmail(email);
			u.setUsername(username);
			u.setPassword(password);
			u.setSpamCheck(s);
			u.setCommercialeId(idAzienda);
			ManagerJPA.addUser(u);
			System.out.println(u);
			System.out.println("utente aggiunto con successo");
			response.sendRedirect("index.html");
		}
		else {
			request.getSession().setAttribute("error", "AGENZIA NON ESISTENTE!!!");
			response.sendRedirect("pages/sign_in_cUser.jsp");
		}
		
	}

}
