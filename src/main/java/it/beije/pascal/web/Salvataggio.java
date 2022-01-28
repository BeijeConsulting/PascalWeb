package it.beije.pascal.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.domus.AnnunciSalvati;
import it.beije.pascal.domus.GestioneAnnuncio;
import it.beije.pascal.domus.Utente;

@WebServlet("/salvataggio")
public class Salvataggio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utente u = (Utente) request.getSession().getAttribute("logged_user");
		int annuncioId = Integer.parseInt(request.getParameter("annuncioId"));

		String commento = request.getParameter("commento");

		AnnunciSalvati annuncioSalvato = new AnnunciSalvati(annuncioId, u.getId(), commento);

		GestioneAnnuncio.salvaAnnuncio(annuncioSalvato);

		response.sendRedirect("domus_home.jsp");

	}

}
