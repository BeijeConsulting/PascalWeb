package it.beije.pascal.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.domus.Annuncio;
import it.beije.pascal.domus.GestioneAnnuncio;
import it.beije.pascal.domus.Utente;


@WebServlet("/visualizzaAnnunciSalvati")
public class VisualizzaAnnunciSalvati extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Utente utente = (Utente) request.getSession().getAttribute("logged_user");
		List<Annuncio> annunciSalvati = GestioneAnnuncio.getAnnunciSalvati(utente.getId());
		request.getSession().setAttribute("listAnnunci", annunciSalvati);
		response.sendRedirect("domus_annunciSalvati.jsp");
	}



}
