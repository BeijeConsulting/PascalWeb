package it.beije.pascal.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.domus.DomusJPA;
import it.beije.pascal.domus.Ricerca;

/**
 * Servlet implementation class SalvaRicerca
 */
@WebServlet("/salva_ricerca")
public class SalvaRicerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalvaRicerca() {
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
		
		//se non sono loggato rimando al login
		if(request.getSession().getAttribute("logged_user") == null) {
			response.sendRedirect("domus_login.html");
		}
		
		Ricerca ricerca = (Ricerca) request.getSession().getAttribute("ricerca");
		DomusJPA.saveRicerca(ricerca);
			
		
		doGet(request, response);
	}

}
