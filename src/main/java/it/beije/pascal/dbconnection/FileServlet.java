package it.beije.pascal.dbconnection;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.beije.pascal.file.Contatto;
import it.beije.pascal.file.XMLCSVmanager;

/**
 * Servlet implementation class FileServlet
 */


@WebServlet("/file")
@MultipartConfig
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   /* public FileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contatto> listcontatto = new ArrayList<>();
	    Part filePart = request.getPart("file"); 
	    String fileName = filePart.getSubmittedFileName();
	    InputStream fileContent = filePart.getInputStream();
	    String choice = request.getParameter("button");
	    if(choice.equals("CSV")) {
	    	listcontatto = XMLCSVmanager.loadRubricaFromCSV(fileContent);
	    } else
			try {
				listcontatto = XMLCSVmanager.loadRubricaFromXML(fileContent);
			} catch (Exception e) {
				System.out.println("Errore lettura XML");
				e.printStackTrace();
			}
	    for(Contatto c : listcontatto) {
	    response.getWriter().append(c.toString() + "\n");
	    }
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
