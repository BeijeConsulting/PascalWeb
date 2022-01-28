package it.beije.pascal.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.domus.GestioneAnnuncio;

@WebServlet("/delete")
public class AnnuncioDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AnnuncioDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		GestioneAnnuncio.delete(id);
		response.sendRedirect("domus_home.jsp");
	}

}
