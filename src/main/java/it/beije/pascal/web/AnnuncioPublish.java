package it.beije.pascal.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.domus.Annuncio;
import it.beije.pascal.domus.DomusJPA;
import it.beije.pascal.domus.Indirizzo;
import it.beije.pascal.domus.Utente;
import it.beije.pascal.domus.enums.StatoRogito;
import it.beije.pascal.domus.enums.TipoAnnuncio;
import it.beije.pascal.domus.enums.TipoImmobile;
import it.beije.pascal.web.exception.NotLoggedException;

/**
 * Servlet implementation class AnnuncioPublish
 */
@WebServlet("/domus/add_annuncio")
public class AnnuncioPublish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnuncioPublish() {
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
		
		Indirizzo indirizzo = new Indirizzo();
		indirizzo.setCap(request.getParameter("cap"));
		indirizzo.setnCivico(Integer.parseInt(request.getParameter("numero")));
		indirizzo.setIndirizzo(request.getParameter("indirizzo"));
		indirizzo.setComune(request.getParameter("comune"));
		
		
		//TODO inserisci indirizzo
		DomusJPA.insertIndirizzo(indirizzo);
		
		Annuncio annuncio = new Annuncio();
		
		String tipoImmString= request.getParameter("tipologia_immobile").toUpperCase();
		TipoImmobile tipoImmobile = TipoImmobile.valueOf(tipoImmString);
		annuncio.setTipoImmobile(tipoImmobile);
		
		String tipoAnnString = request.getParameter("tipologia_annuncio").toUpperCase();
		TipoAnnuncio tipoAnnuncio = TipoAnnuncio.valueOf(tipoAnnString);
		annuncio.setTipoAnnuncio(tipoAnnuncio);
		
		String statoRogitoString = request.getParameter("stato_rogito").toUpperCase();
		StatoRogito statoRogito = StatoRogito.valueOf(statoRogitoString);
		annuncio.setStatoRogito(statoRogito);
		
		annuncio.setMq(Integer.parseInt(request.getParameter("mq")));
		annuncio.setPrezzo(Integer.parseInt(request.getParameter("prezzo")));
		annuncio.setVisitaGuidata(request.getAttribute("visita_guidata")!=null && ((String)request.getAttribute("visita_guidata")).equals("on"));
		annuncio.setVirtualTour(request.getAttribute("virtual_tour")!=null && ((String)request.getAttribute("virtual_tour")).equals("on"));
		
		//TODO prima devo gestire l'indirizzo
		// TODO finisci i parametri e carica
		//TODO venditore id come utente loggato
		
		//test
		Utente loggedUser = (Utente)request.getSession().getAttribute("logged_user");
		if(loggedUser.getEmail()==null) throw new RuntimeException("User not logged in");
		annuncio.setVenditoriId(loggedUser.getId());
		annuncio.setIndirizzoId(indirizzo.getId());
		System.out.println(indirizzo);
		System.out.println(annuncio);
		DomusJPA.insertAnnuncio(annuncio);
		
		doGet(request, response);
	}

}
