package it.beije.pascal.web;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first_servlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet GET");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		StringBuilder html = new StringBuilder("<!DOCTYPE html>\r\n" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"ISO-8859-1\">" + 
				"<title >PASCAL HTTP SERVLET</title>" + 
				"</head>" + 
				"<body>" + 
				"<h1 style=\"background-color:powderblue;\">HELLO WORLD</h1>");
		html.append("TI CHIAMI: ").append(fname)
		.append("<br/>").append("COGNOME: ").append(lname);
		html.append("</br></br> Sone le ").append(LocalTime.now().toString()).append("<br/> <a href='index.html'>clicca</a>");
		html.append("</body></html>");
		
		response.getWriter().append(html.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet POST");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		response.getWriter().append("fname: ").append(fname).append(", lname: ").append(lname);		
	}

}
