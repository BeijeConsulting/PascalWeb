package it.beije.pascal.web.tabella.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.web.tabella.bean.Contatto;
import it.beije.pascal.web.tabella.query.Sql;

/**
 * Servlet implementation class SaveContattoServlet
 */
@WebServlet("/save")
public class SaveContattoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveContattoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		Contatto contatto = new Contatto(nome,cognome,telefono,email,note);
		Sql.save(contatto);		
		
		response.sendRedirect("_table/contatti.jsp");
		
	}


}


























