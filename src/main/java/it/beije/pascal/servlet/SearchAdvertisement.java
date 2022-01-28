package it.beije.pascal.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.bean.Annuncio;
import it.beije.pascal.bean.enums.TipoAnnuncio;
import it.beije.pascal.bean.enums.TipoImmobile;
import it.beije.pascal.database.ManagerJPA;

/**
 * Servlet implementation class SearchAdvertisement
 */
@WebServlet("/searchAdvertisement")
public class SearchAdvertisement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchAdvertisement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("pages/search_advertisement.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String citta = request.getParameter("citta");

		String ti = request.getParameter("tipoImmobile");
		TipoImmobile tipoImmobile = TipoImmobile.valueOf(ti);

		Annuncio a = ManagerJPA.searchAdvertisement(tipoImmobile);

		if (a != null) {

			request.getSession().setAttribute("adv", a);
			response.sendRedirect("pages/adv_details.jsp");

		} else {
			
			request.getSession().setAttribute("error", "NESSUN ANNUNCIO TROVATO");
			response.sendRedirect("pages/search_advertisement.jsp");
		}

	}

}
