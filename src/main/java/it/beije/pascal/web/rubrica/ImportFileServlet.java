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
import it.beije.pascal.rubrica.RubricaCSV;
import it.beije.pascal.rubrica.RubricaJPA;
import it.beije.pascal.rubrica.RubricaXML;

/**
 * Servlet implementation class ImportCsvServlet
 */
@WebServlet("/import_file")
public class ImportFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseConnection rubricaDB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportFileServlet() {
        super();
        rubricaDB = new RubricaJPA();    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contatto> contatti;
		
		String fileName = request.getParameter("nome_file");
		if(fileName == null) return;
		if(fileName.endsWith(".csv"))
			contatti = RubricaXML.loadRubricaFromXML(fileName);
		else if(fileName.endsWith(".xml"))
			contatti = RubricaCSV.loadRubricaFromCSV(fileName, RubricaCSV.STANDARD_SEPARATOR);
		else {
			return;
		}
		
		request.getSession().setAttribute("contatti_list", contatti);
		response.sendRedirect("list_contatti");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
