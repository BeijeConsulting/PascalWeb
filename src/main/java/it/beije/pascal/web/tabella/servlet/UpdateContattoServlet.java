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
 * Servlet implementation class UpdateContattoServlet
 */
@WebServlet("/update")
public class UpdateContattoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateContattoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String note = request.getParameter("note");		
		Contatto contatto = new Contatto(id,cognome,nome,telefono,email,note);
		Sql.update(contatto);
		
		response.sendRedirect("_table/contatti.jsp");	
		
	}

}
