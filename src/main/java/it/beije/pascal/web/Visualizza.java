package it.beije.pascal.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.domus.Annuncio;
import it.beije.pascal.domus.GestioneAnnuncio;
import it.beije.pascal.domus.Indirizzo;

@WebServlet("/visualizza")
public class Visualizza extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idIndirizzo = Integer.parseInt(request.getParameter("idIndirizzo"));
		int idAnnuncio = Integer.parseInt(request.getParameter("idAnnuncio"));
		Indirizzo ind = GestioneAnnuncio.getIndirizzo(idIndirizzo);
		Annuncio ann = GestioneAnnuncio.getAnnuncio(idAnnuncio);

		request.getSession().setAttribute("indirizzo", ind);
		request.getSession().setAttribute("annuncio", ann);

		response.sendRedirect("domus_visualizza.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
