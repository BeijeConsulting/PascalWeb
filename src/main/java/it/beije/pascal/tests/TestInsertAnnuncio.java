package it.beije.pascal.tests;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.bean.Annuncio;
import it.beije.pascal.bean.Utente;
import it.beije.pascal.bean.enums.StatoRogito;
import it.beije.pascal.bean.enums.TipoAnnuncio;
import it.beije.pascal.bean.enums.TipoImmobile;
import it.beije.pascal.database.JPA;

/**
 * Servlet implementation class TestInsertAnnuncio
 */
@WebServlet("/testinsertannuncio")
public class TestInsertAnnuncio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestInsertAnnuncio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Annuncio annuncio = new Annuncio();
		annuncio.setTipoImmobile(TipoImmobile.casa);
		annuncio.setTipoAnnuncio(TipoAnnuncio.vendita);
		annuncio.setMq(1000);
		annuncio.setStatoRogito(StatoRogito.libero);
		annuncio.setVisitaGuidata(false);
		annuncio.setVirtualTour(false);
		try {
			JPA.inserisciAnnuncio(annuncio);
		} catch (Exception e) {
			System.out.println("Annuncio soos");
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
