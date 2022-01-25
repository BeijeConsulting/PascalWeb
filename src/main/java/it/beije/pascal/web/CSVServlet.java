package it.beije.pascal.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.rubrica.CSVmanager;
import it.beije.pascal.rubrica.Contatto;
import it.beije.pascal.rubrica.JPAmanager;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/csv_servlet")
public class CSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("csv_servlet GET");
		if (request.getParameter("DataBase") != null) {
			StringBuilder html = new StringBuilder("<!DOCTYPE html>\r\n" + "<html>" + "<head>"
					+ "<meta charset=\"ISO-8859-1\">" + "<title >Data form database</title>" + "</head>" + "<body>"
					+ "<h1 style=\"background-color:powderblue;\">Contatti da Database</h1>");

			List<Contatto> contatti = JPAmanager.categoriaJPA();

			for (Contatto contatto : contatti) {
				html.append(contatto);
				html.append("<br>");
			}

			html.append("<br/> <a href='index.html'>clicca</a>");
			html.append("</body></html>");
			response.getWriter().append(html.toString());
		} else if (request.getParameter("CSV") != null) {
			StringBuilder html = new StringBuilder("<!DOCTYPE html>\r\n" + "<html>" + "<head>"
					+ "<meta charset=\"ISO-8859-1\">" + "<title >Data form csv</title>" + "</head>" + "<body>"
					+ "<h1 style=\"background-color:powderblue;\">Contatti da csv</h1>");

			List<String> contatti = CSVmanager.readingFile(new File("C:/Users/andre/git/Pascal/rubrica.csv"));

			for (String contatto : contatti) {
				html.append(contatto);
				html.append("<br>");
			}

			html.append("<br/> <a href='index.html'>clicca</a>");
			html.append("</body></html>");
			response.getWriter().append(html.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("csv_servlet POST");

		if (request.getParameter("insert") != null) {
			System.out.println("insert");

			insert(request, response);

		} else if (request.getParameter("select") != null) {
			System.out.println("select");

			select(request, response);
		}
		else if (request.getParameter("update") != null) {
			System.out.println("update");
			
			update(request, response);
		}
		else if (request.getParameter("delete") != null) {
			delete(request, response);
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

		StringBuilder html = new StringBuilder("<!DOCTYPE html>\r\n" + "<html>" + "<head>"
				+ "<meta charset=\"ISO-8859-1\">" + "<title >PASCAL HTTP SERVLET</title>" + "</head>" + "<body>"
				+ "<h1 style=\"background-color:powderblue;\">Contatti</h1>");

		html.append("cognome: ").append(cognome).append(", nome: ").append(nome).append("telefono: ")
				.append(telefono).append(", email: ").append(email).append("note: ").append(note)
				.append("  aggiunto");

		html.append("<br/> <a href='index.html'>clicca</a>");
		html.append("</body></html>");
		response.getWriter().append(html.toString());
	}

	private void select(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String category = request.getParameter("category");
		String value = request.getParameter("value");

		List<Contatto> contatti = JPAmanager.findJPA(value, category);

		StringBuilder html = new StringBuilder("<!DOCTYPE html>\r\n" + "<html>" + "<head>"
				+ "<meta charset=\"ISO-8859-1\">" + "<title >PASCAL HTTP SERVLET</title>" + "</head>" + "<body>"
				+ "<h1 style=\"background-color:powderblue;\">Contatti</h1>");

		for (Contatto contatto : contatti) {
			System.out.println(contatto);
			html.append(contatto);
			html.append("<br>");
		}
		html.append("<br/> <a href='index.html'>clicca</a>");
		html.append("</body></html>");
		response.getWriter().append(html.toString());
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idc = Integer.parseInt(request.getParameter("idcontatto"));
		String category = request.getParameter("cat");
		String value = request.getParameter("newvalue");
		
		StringBuilder html = new StringBuilder("<!DOCTYPE html>\r\n" + "<html>" + "<head>"
				+ "<meta charset=\"ISO-8859-1\">" + "<title >PASCAL HTTP SERVLET</title>" + "</head>" + "<body>"
				+ "<h1 style=\"background-color:powderblue;\">contatto aggiornato</h1>");

		JPAmanager.updateContattoJPA(idc, category, value);
		
		html.append("<br/> <a href='index.html'>clicca</a>");
		html.append("</body></html>");
		response.getWriter().append(html.toString());
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("select");

		int idc = Integer.parseInt(request.getParameter("idcontatto"));
		
		StringBuilder html = new StringBuilder("<!DOCTYPE html>\r\n" + "<html>" + "<head>"
				+ "<meta charset=\"ISO-8859-1\">" + "<title >PASCAL HTTP SERVLET</title>" + "</head>" + "<body>"
				+ "<h1 style=\"background-color:powderblue;\">contatto cancellato</h1>");

		JPAmanager.deleteJPA(idc);
		html.append("<br/> <a href='index.html'>clicca</a>");
		html.append("</body></html>");
		response.getWriter().append(html.toString());
	}

}