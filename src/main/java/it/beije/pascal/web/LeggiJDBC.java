package it.beije.pascal.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LeggiJDBC
 */
@WebServlet("/LeggiJDBC")
public class LeggiJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeggiJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/rubrica?serverTimezone=CET", "root", "andrea23596");
			System.out.println(!c.isClosed());
			
			Statement s = c.createStatement();
			
			ResultSet rs = null;
			rs = s.executeQuery("SELECT * FROM contatti");
			
			while(rs.next()) {
				sb.append("cognome : " + rs.getString("cognome")+ '\n');
				sb.append("nome : " + rs.getString("nome")+ '\n');
				sb.append("telefono : " + rs.getString("telefono")+ '\n');
				sb.append("email : " + rs.getString("email")+ '\n');
				sb.append("note : " + rs.getString("note")+ '\n');
				sb.append("\n"+ '\n'+ '\n');
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append(sb.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
