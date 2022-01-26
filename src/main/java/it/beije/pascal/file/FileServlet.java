package it.beije.pascal.file;

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

import org.w3c.dom.html.HTMLDocument;

import it.beije.pascal.bean.Contatto;

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
    public FileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part filePart = request.getPart("file");
	    
		String fileName = filePart.getSubmittedFileName();
	    InputStream fileContent = filePart.getInputStream();
	    
	    
	    List<Contatto> list = null;
	    
	    if(request.getParameter("button").equals("CSV")) {
	    	list = LoadReadXML_CSV.loadRubricaFromCSV(fileContent);
	    }else {
	    	try {
				list = LoadReadXML_CSV.loadRubricaFromXML(fileContent);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    for(Contatto c : list) {
	    	response.getWriter().append(c.toString() + "\n");
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
