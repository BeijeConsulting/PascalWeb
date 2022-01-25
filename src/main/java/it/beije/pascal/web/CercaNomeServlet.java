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
import it.beije.pascal.web.util.ContattoWebUtil;

/**
 * Servlet implementation class CercaNomeServlet
 */
@WebServlet("/cerca_nome")
public class CercaNomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseConnection rubricaDB;  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CercaNomeServlet() {
        super();
        rubricaDB = new RubricaJPA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		List<Contatto> contattiList = rubricaDB.cercaContattoNomeCognome(nome, cognome);
		
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
