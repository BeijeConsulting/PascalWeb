package it.beije.pascal.web.domus;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.cfg.Configuration;

import it.beije.pascal.web.beans.Annuncio;
import it.beije.pascal.web.beans.Indirizzo;
import it.beije.pascal.web.beans.Utente;
import it.beije.pascal.web.enums.TipoAnnuncio;
import it.beije.pascal.web.enums.TipoImmobile;

/**
 * Servlet implementation class aggiungiAnnuncio
 */
@WebServlet("/aggiungiAnnuncio")
public class aggiungiAnnuncio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("inserisciAnnuncio.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String comune = request.getParameter("comune");
		String indirizzo = request.getParameter("indirizzo");
		int civico = Integer.parseInt(request.getParameter("civico"));
		String cap = request.getParameter("cap");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pippo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Indirizzo i = new Indirizzo();
		i.setCap(cap);
		i.setCivico(civico);
		i.setComune(comune);
		i.setIndirizzo(indirizzo);
		entityManager.persist(i);
		transaction.commit();
		
		int id = i.getId();
		
		String tipoImmobile = request.getParameter("tipoImmobile").toUpperCase();
		TipoImmobile ti = TipoImmobile.valueOf(tipoImmobile);
		
		String tipoAnnuncio = request.getParameter("tipoAnnuncio").toUpperCase();
		TipoAnnuncio ta = TipoAnnuncio.valueOf(tipoAnnuncio);
		
		transaction.begin();
		Annuncio a = new Annuncio();
		Utente u = (Utente)request.getSession().getAttribute("loggedUser");
		a.setVenditoriId(u.getId());
		a.setTipoImmobile(ti);
		a.setTipoAnnuncio(ta);
		a.setPrezzo(Integer.parseInt(request.getParameter("prezzo")));
		a.setMq(Integer.parseInt(request.getParameter("metriQuadri")));
		a.setLocali(Integer.parseInt(request.getParameter("locali")));
		a.setBagni(Integer.parseInt(request.getParameter("bagni")));
		a.setPiano(Integer.parseInt(request.getParameter("piani")));
		a.setAscensore(request.getAttribute("ascensore") == "on");
		a.setPostiAuto(Integer.parseInt(request.getParameter("postiAuto")));
		a.setBalcone(request.getAttribute("balcone") == "on");
		a.setTerrazzo(request.getAttribute("terrazza") == "on");
		a.setPiscina(request.getAttribute("piscina") == "on");
		
		
		
		entityManager.close();
		
		response.sendRedirect("annuncioPubblicato.jsp");
		
		
	}

}
