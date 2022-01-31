package it.beije.pascal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.bean.Commerciale;
import it.beije.pascal.bean.Indirizzo;
import it.beije.pascal.database.ManagerJPA;

/**
 * Servlet implementation class RegisterEstate
 */
@WebServlet("/registerEstate")
public class RegisterEstate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterEstate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("pages/sign_in_estate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ragioneSociale = request.getParameter("ragioneSociale");
		String cognomeReferente = request.getParameter("cognomeReferente");
		String nomeReferente = request.getParameter("nomeReferente");
		String telefono = request.getParameter("telefono");
		String partitaIva = request.getParameter("partitaIva");
		String comune = request.getParameter("comune");
		String via = request.getParameter("via");
		String cap = request.getParameter("cap");
		String civico = request.getParameter("civico");
		
		Indirizzo i = new Indirizzo();
		i.setComune(comune);
		i.setIndirizzo(via);
		i.setCap(cap);
		i.setNCivico(Integer.parseInt(civico));
		
		ManagerJPA.addAddress(i);
		int idIndirizzo = i.getId();
		
		Commerciale c = new Commerciale();
		c.setRagioneSociale(ragioneSociale);
		c.setCognomeRef(cognomeReferente);
		c.setNomeRef(nomeReferente);
		c.setTelefono(telefono);
		c.setPIva(partitaIva);
		c.setIndirizzoId(idIndirizzo);
		
		ManagerJPA.addCommercial(c);
		System.out.println("agenzia aggiunta");
		
		response.sendRedirect("index.html");
	}

}
