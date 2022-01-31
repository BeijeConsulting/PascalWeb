package it.beije.pascal.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.domus.GestioneAnnuncio;

/**
 * Servlet implementation class DeleteAnnuncioSalvato
 */
@WebServlet("/remove_annuncio_salvato")
public class DeleteAnnuncioSalvato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAnnuncioSalvato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int salvataggioId = Integer.parseInt(request.getParameter("annuncioId")) ;
		int utenteId = Integer.parseInt(request.getParameter("utenteId")) ;

		GestioneAnnuncio.removeSalvato(salvataggioId, utenteId);
		
		response.sendRedirect("visualizzaAnnunciSalvati");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
