package it.beije.pascal.web.rubrica.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.pascal.web.rubrica.bean.Contatto;



@WebServlet("/FindAllContattiServlet")
public class FindAllContattiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public FindAllContattiServlet() {
        super();        
    }


    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contatto> contatti = findAll();
		PrintWriter writer = response.getWriter();
		
		for(Contatto contatto:contatti) {
			writer.write("<p>" + contatto + "</p>");
		}
	}

	private static List<Contatto> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rubrica");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "SELECT c FROM Contatto AS c";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
		return contatti;
	}
	

}
