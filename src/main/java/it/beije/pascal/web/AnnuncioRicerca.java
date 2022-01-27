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
		String localita = request.getParameter("localita");
		List<Annuncio> annunci = GestioneAnnuncio.cercaAnnunci(tipoImmobile, tipoAnnuncio, localita);
		for(Annuncio annuncio:annunci) {
			System.out.println(annuncio);
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
