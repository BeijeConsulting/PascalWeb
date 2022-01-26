package it.beije.pascal.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.rubrica.Contatto;
import it.beije.pascal.rubrica.DatabaseConnection;
import it.beije.pascal.rubrica.RubricaJPA;

/**
 * Servlet implementation class DbRubricaServlet
 */
//@WebServlet("/list_contatti")
public class DbRubricaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DatabaseConnection rubricaDB;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DbRubricaServlet() {
        super();
        rubricaDB = new RubricaJPA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean ascendent = ((String) request.getAttribute("order_direction")).equals("ascendente");
		List<Contatto> contattiList = rubricaDB.listAllOrderedBy((String)request.getAttribute("order_column"), ascendent);
		
//		response.getWriter().append(ContattoWebUtil.tabellaContattiHtml(contattiList));
		request.getSession().setAttribute("contatti_list", contattiList);
		response.sendRedirect("tabella_ricerca.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
