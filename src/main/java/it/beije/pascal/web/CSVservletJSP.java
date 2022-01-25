package it.beije.pascal.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.pascal.rubrica.CSVmanager;
import it.beije.pascal.rubrica.Contatto;
import it.beije.pascal.rubrica.JPAmanager;

@WebServlet("/csv_servletJSP")
public class CSVservletJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("JSP get");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("JSP post");
		if (request.getParameter("select") != null) {
			System.out.println("select");
			String category = request.getParameter("category");
			String value = request.getParameter("value");

			List<Contatto> contatti = JPAmanager.findJPA(value, category);

			HttpSession session = request.getSession();
			session.setAttribute("contatti", contatti);

			response.sendRedirect("index.jsp");
		} else if (request.getParameter("delete") != null) {
			System.out.println("delete");
			int id = Integer.parseInt(request.getParameter("id"));

			JPAmanager.deleteJPA(id);

			response.sendRedirect("index.jsp");
		} else if (request.getParameter("insert") != null) {
			System.out.println("insert");
			insert(request, response);

		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cognome = request.getParameter("cognome");
		String nome = request.getParameter("nome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String note = request.getParameter("note");

		Contatto cont = new Contatto(cognome, nome, telefono, email, note);

		JPAmanager.insertJPA(cont);

		response.sendRedirect("index.jsp");
	}
}
