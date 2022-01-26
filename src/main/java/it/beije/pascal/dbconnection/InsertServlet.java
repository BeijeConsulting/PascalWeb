package it.beije.pascal.dbconnection;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.pascal.file.Contatto;
import it.beije.pascal.file.JPAConnection;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contatto newContatto = new Contatto();
		String nome = request.getParameter("nome");
		newContatto.setNome(nome);
		String cognome = request.getParameter("cognome");
		newContatto.setCognome(cognome);
		String telefono = request.getParameter("telefono");
		newContatto.setTelefono(telefono);
		String email = request.getParameter("email");
		newContatto.setEmail(email);
		String note = request.getParameter("note");
		newContatto.setNote(note);
		JPAConnection.Insert(newContatto);
		
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
