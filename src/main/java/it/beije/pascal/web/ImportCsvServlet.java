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
import it.beije.pascal.rubrica.RubricaXML;

/**
 * Servlet implementation class ImportCsvServlet
 */
@WebServlet("/import_csv")
public class ImportCsvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseConnection rubricaDB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportCsvServlet() {
        super();
        rubricaDB = new RubricaJPA();    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = "./rubrica.csv";
		List<Contatto> contatti = RubricaXML.loadRubricaFromXML(fileName);
		for (Contatto c : contatti) // TODO change to single query
			rubricaDB.inserisciContatto(c);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
