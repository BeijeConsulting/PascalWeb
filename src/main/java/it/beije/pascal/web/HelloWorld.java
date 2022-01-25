package it.beije.pascal.web;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hello")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloWorld() {
        super();
        System.out.println("hello!!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloWorld GET");
		StringBuilder html = new StringBuilder("<!DOCTYPE html>\r\n" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"ISO-8859-1\">" + 
				"<title>PASCAL SERVLET</title>" + 
				"</head>" + 
				"<body>" + 
				"<h1>HELLO WORLD</h1>");
		
		html.append("Sono le ").append(LocalTime.now().toString())
			.append("<br/>").append(request.getSession().getAttribute("fname"))
			.append(" ").append(request.getSession().getAttribute("lname"))
			.append("</body></html>");
		
		response.getWriter().append(html.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloWorld POST");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		HttpSession session = request.getSession();
		session.setAttribute("fname", fname);
		session.setAttribute("lname", lname);

//		StringBuilder html = new StringBuilder("<!DOCTYPE html>\r\n" + 
//				"<html>" + 
//				"<head>" + 
//				"<meta charset=\"ISO-8859-1\">" + 
//				"<title>PASCAL HTTP SERVLET</title>" + 
//				"</head>" + 
//				"<body>");
//		
//		html.append("FNAME: ").append(fname)
//			.append("<br/>").append("LNAME: ").append(lname)
//			.append("</body></html>");
//		
//		response.getWriter().append(html.toString());
		
		response.sendRedirect("hello.jsp");
	}

}
