package it.beije.pascal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.bean.Commerciale;
import it.beije.pascal.bean.Utente;
import it.beije.pascal.database.ManagerJPA;
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
		System.out.println("email : " + email);
		
//		Commerciale c = new Commerciale();
//		c.setCognomeRef("gliori");
//		c.setNomeRef("andrea");
//		c.setPIva("1234");
//		c.setRagioneSociale("ragione sociale");
//		c.setTelefono("3334445556");
//		ManagerJPA.addcommercial(c);
		
		Utente u = new Utente();
		u.setEmail(email);
		u.setUsername(username);
		u.setPassword(password);
//		u.setCommercialeId(0);
		
		ManagerJPA.addUser(u);
		
		System.out.println(u);
		System.out.println("utente aggiunto con successo");
		
		response.sendRedirect("index.html");
		
	}
}
