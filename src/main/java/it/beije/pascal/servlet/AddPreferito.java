package it.beije.pascal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.bean.AnnunciSalvati;
import it.beije.pascal.bean.Utente;
import it.beije.pascal.database.ManagerJPA;

/**
 * Servlet implementation class AddPreferito
 */
@WebServlet("/addpreferito")
public class AddPreferito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPreferito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int utenteId = Integer.parseInt(request.getParameter("utente"));
		int annuncioId = Integer.parseInt(request.getParameter("annuncio"));
		
		AnnunciSalvati annS = new AnnunciSalvati();
		annS.setAnnuncioid(annuncioId);
		annS.setUtenteid(utenteId);
		
		ManagerJPA.addPref(annS);
		response.sendRedirect("pages/show_ads.jsp");
	}

}
