package it.beije.pascal.web;

import java.io.IOException;
import java.time.LocalDate;
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

		response.getWriter().append("Sone le ").append(LocalTime.now().toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name 	= request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		String gender 	= request.getParameter("check_gen");
		LocalDate bday	= LocalDate.parse(request.getParameter("birthday"));
		
		StringBuilder html = new StringBuilder("<!DOCTYPE html>\r\n" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"ISO-8859-1\">" + 
				"<title>PASCAL HTTP SERVLET</title>" + 
				"</head>" + 
				"<body>");
		
		html.append("name: ").append(name)
			.append("<br/>").append("last name: ").append(lastname)
			.append("<br/>").append("gender: ").append(gender)
			.append("<br/>").append("bday: ").append(bday.toString())
			.append("</body></html>");
		response.getWriter().append(html.toString());
	}

}
