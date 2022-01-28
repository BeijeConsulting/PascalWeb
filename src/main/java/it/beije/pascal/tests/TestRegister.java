package it.beije.pascal.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.pascal.bean.Annuncio;
import it.beije.pascal.bean.Utente;
import it.beije.pascal.bean.enums.StatoRogito;
import it.beije.pascal.bean.enums.TipoAnnuncio;
import it.beije.pascal.bean.enums.TipoImmobile;
import it.beije.pascal.database.JPA;



/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/testregister")
public class TestRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Annuncio annuncio = new Annuncio();
//		annuncio.setTipoImmobile(TipoImmobile.CASA);
//		annuncio.setTipoAnnuncio(TipoAnnuncio.VENDITA);
//		annuncio.setMq(1000);
//		annuncio.setStatoRogito(StatoRogito.LIBERO);
//		annuncio.setVisitaGuidata(false);
//		annuncio.setVirtualTour(false);
//		try {
//			JPA.inserisciAnnuncio(annuncio);
//		} catch (Exception e) {
//			System.out.println("Annuncio soos");
//			e.printStackTrace();
//		}
//		List<Annuncio> listann = new ArrayList<>();
//		listann.add(annuncio);
		Utente newContatto = new Utente();
		String email = request.getParameter("email");
		newContatto.setEmail(email);
		String password = request.getParameter("password");
		newContatto.setPassword(password);
		//boolean spam_check = Boolean.parseBoolean(request.getParameter("spam_check")) ;
		newContatto.setSpamCheck(false);
		//boolean amministratore = Boolean.parseBoolean(request.getParameter("amministratore"));
		newContatto.setAmministratore(false);
//		newContatto.setAnnunciSalvati(listann);
		try {
			TestInsert.inserisciUtente(newContatto);
		} catch (Exception e) {
			System.out.println("Insert soos");
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		response.sendRedirect("homepage.jsp");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
