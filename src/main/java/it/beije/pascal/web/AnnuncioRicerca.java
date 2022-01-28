package it.beije.pascal.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.pascal.domus.Annuncio;
import it.beije.pascal.domus.GestioneAnnuncio;


@WebServlet("/ricerca")
public class AnnuncioRicerca extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AnnuncioRicerca() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoImmobile = request.getParameter("tipoImmobile");
		String tipoAnnuncio = request.getParameter("tipoAnnuncio");
		String comune = request.getParameter("comune");	
		List<Annuncio> annunci = GestioneAnnuncio.cercaAnnunci(tipoImmobile, tipoAnnuncio, comune);
		HttpSession session = request.getSession();
		session.setAttribute("annunci", annunci);
		for(Annuncio annuncio:annunci) {
			System.out.println(annuncio);
		}
		
		response.sendRedirect("domus/domus_annunci.jsp");
		

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
