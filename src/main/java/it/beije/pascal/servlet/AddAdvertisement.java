package it.beije.pascal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.bean.enums.TipoImmobile;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("pages/add_advertisement.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ti = request.getParameter("tipoImmobile").toUpperCase();
		TipoImmobile tipoImmobile = TipoImmobile.valueOf(ti);
		
		String ta = request.getParameter("tipoAnnuncio").toUpperCase();
		TipoAnnuncio tipoAnnuncio = TipoAnnuncio.valueOf(ta);
		
		Indirizzo indirizzo = new Indirizzo();
		indirizzo.setComune(request.getParameter("comune"));
		indirizzo.setIndirizzo(request.getParameter("indirizzo"));
		indirizzo.setCap(request.getParameter("cap"));
		indirizzo.setNCivico(Integer.parseInt(request.getParameter("numeroCivico")));
		
		int prezzo = Integer.parseInt(request.getParameter("prezzo"));
		
		int mq = Integer.parseInt(request.getParameter("mq"));
		
		int locali = Integer.parseInt(request.getParameter("locali"));
		
		int bagni = Integer.parseInt(request.getParameter("bagni"));
		
		int tot_piani = Integer.parseInt(request.getParameter("tot_piani"));
		
		int piano = Integer.parseInt(request.getParameter("piano"));
		
		boolean ascensore = Boolean.parseBoolean(request.getParameter("ascensore"));
		
		int postiAuto = Integer.parseInt(request.getParameter("postiAuto"));
		
		boolean balcone = Boolean.parseBoolean(request.getParameter("balcone"));
		
		boolean terrazzo = Boolean.parseBoolean(request.getParameter("terrazzo"));
		
		String g = request.getParameter("giardino").toUpperCase();
		Giardino giardino = Giardino.valueOf(g);
		
		String c = request.getParameter("condizione").toUpperCase();
		Condizione condizione = Condizione.valueOf(c);
		
		String ce = request.getParameter("classeEnergetica").toUpperCase();
		ClasseEnergetica classeEnergetica = ClasseEnergetica.valueOf(ce);
		
		String r = request.getParameter("riscaldamento").toUpperCase();
		Riscaldamento riscaldamento = Riscaldamento.valueOf(r);
		
		String ac = request.getParameter("ariaCondizionata").toUpperCase();
		AriaCondizionata ariaCondizionata = AriaCondizionata.valueOf(ac);
		
		String ar = request.getParameter("arredamento").toUpperCase();
		Arredamento arredamento = Arredamento.valueOf(ar);
		
		boolean piscina = Boolean.parseBoolean(request.getParameter("piscina"));
		
		boolean portineria = Boolean.parseBoolean(request.getParameter("portineria"));
		
		short annoCostruzione = Short.parseShort(request.getParameter("annoCostruzione"));
		
		String sr = request.getParameter("statoRogito").toUpperCase();
		StatoRogito statoRogito = StatoRogito.valueOf(sr);
		
		boolean visitaGuidata = Boolean.parseBoolean(request.getParameter("visitaGuidata"));
		
		String descrizioneLunga = request.getParameter("descrizioneLunga");
		
		boolean virtualTour = Boolean.parseBoolean(request.getParameter("virtualTour"));
		
		Annuncio annuncio = new Annuncio();
		
		
		doGet(request, response);
	}

}
