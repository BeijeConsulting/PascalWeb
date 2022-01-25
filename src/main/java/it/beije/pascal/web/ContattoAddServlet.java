package it.beije.pascal.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.rubrica.Contatto;
import it.beije.pascal.rubrica.DatabaseConnection;
import it.beije.pascal.rubrica.RubricaJPA;

/**
 * Servlet implementation class ContattoAddServlet
 */
@WebServlet("/add_contatto")
public class ContattoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseConnection rubricaDB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContattoAddServlet() {
        super();
        rubricaDB = new RubricaJPA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome 	= request.getParameter("name");
		String cognome 	= request.getParameter("lastname");
		String tel 		= request.getParameter("phone");
		String email 	= request.getParameter("email");
		String note	 	= request.getParameter("note");
		
		Contatto c = new Contatto();
		c.setCognome(cognome);
		c.setNome(nome);
		c.setTelefono(tel);
		c.setEmail(email);
		c.setNote(note);
		
		rubricaDB.inserisciContatto(c);
		
		response.getWriter().append("Added: " + c.toString()).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
