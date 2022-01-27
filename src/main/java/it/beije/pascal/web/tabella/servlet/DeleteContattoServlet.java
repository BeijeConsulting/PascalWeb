package it.beije.pascal.web.tabella.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.web.tabella.query.Sql;

/**
 * Servlet implementation class DeleteContattoServelt
 */
@WebServlet("/delete")
public class DeleteContattoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteContattoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); 
		System.out.println("Valore id: " + id);
		Sql.delete(id);
		response.sendRedirect("_table/contatti.jsp");
	}

	
}
