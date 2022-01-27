package it.beije.pascal.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.rubrica.Contatto;
import it.beije.pascal.rubrica.DatabaseConnection;
import it.beije.pascal.rubrica.RubricaJPA;

/**
 * Servlet implementation class ListContattiServlet
 */
@WebServlet("/list_contatti")
public class ListContattiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DatabaseConnection rubricaDB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListContattiServlet() {
        super();
        rubricaDB = new RubricaJPA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean ascendent = ((String) request.getParameter("order_direction")).equals("ascendente");
		List<Contatto> contattiList = rubricaDB.listAllOrderedBy((String)request.getParameter("order_column"), ascendent);
		
		request.getSession().setAttribute("contatti_list", contattiList);
		response.sendRedirect("tabella_ricerca.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
