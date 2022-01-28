package it.beije.pascal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.bean.enums.TipoImmobile;
import it.beije.pascal.database.ManagerJPA;
import it.beije.pascal.utility.ServletUtility;
import it.beije.pascal.bean.Annuncio;
import it.beije.pascal.bean.Indirizzo;
import it.beije.pascal.bean.enums.AriaCondizionata;
import it.beije.pascal.bean.enums.Arredamento;
import it.beije.pascal.bean.enums.ClasseEnergetica;
import it.beije.pascal.bean.enums.Condizione;
import it.beije.pascal.bean.enums.Giardino;
import it.beije.pascal.bean.enums.Riscaldamento;
import it.beije.pascal.bean.enums.StatoRogito;
import it.beije.pascal.bean.enums.TipoAnnuncio;

/**
 * Servlet implementation class AddAdvertisement
 */
@WebServlet("/addAdvertisement")
public class AddAdvertisement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAdvertisement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("pages/add_advertisement.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Indirizzo indirizzo = ServletUtility.createAddress(request);
		ManagerJPA.addAddress(indirizzo);
		int indirizzoId = indirizzo.getId();

		Annuncio annuncio = ServletUtility.createAdvertisement(request, indirizzoId);
		ManagerJPA.addAdvertisement(annuncio);
		
		System.out.println("Annuncio aggiunto");
		response.sendRedirect("pages/personal_page.jsp");
	}

}
