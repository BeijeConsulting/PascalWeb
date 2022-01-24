package it.beije.pascal.web;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/hello")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        System.out.println("hello!!");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloWorld GET");
		StringBuilder html = new StringBuilder("<!DOCTYPE html>\r\n" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"ISO-8859-1\">" + 
				"<title>PASCAL HTTP SERVLET</title>" + 
				"</head>" + 
				"<body>" + 
				"<h1>HELLO WORLD</h1>");
		
		html.append("Sono le ").append(LocalTime.now().toString()).append("</body></html>");
		
		response.getWriter().append(html.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloWorld POST");
		String fname = request.getParameter("name");
		String lname = request.getParameter("lname");
		String button = request.getParameter("rbutt");
		String[] checks = request.getParameterValues("check");


		StringBuilder html = new StringBuilder("<!DOCTYPE html>\r\n" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"ISO-8859-1\">" + 
				"<title>PASCAL HTTP SERVLET</title>" + 
				"</head>" + 
				"<body>");
		
		html.append("FNAME: ").append(fname)
			.append("<br/>").append("LNAME: ").append(lname)
			.append("<br/>").append("BUTTON: ").append(button)
			.append("<br/>").append("CHECK: ").append(checks[1])
			.append("</body></html>");
		
		response.getWriter().append(html.toString());
	}

}
