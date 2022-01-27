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
 * Servlet implementation class ContattoModificaServlet
 */
@WebServlet("/modifica")
public class ContattoModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseConnection rubricaDB;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContattoModificaServlet() {
        super();
        rubricaDB = new RubricaJPA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//FIXME swotch sul tipo di bottone che ha richiesto
		//if(request.getParameter("name")!=null) 
		visualizzaContatto(request, response);
		doGet(request, response);
		
	}

	private void visualizzaContatto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Contatto c = rubricaDB.getContatto(Integer.parseInt(request.getParameter("id")));
		request.getSession().setAttribute("contatto_sel", c);
		response.sendRedirect("modifica_form.jsp");
			
	}


	
	

}
