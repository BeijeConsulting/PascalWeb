package it.beije.pascal.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@WebServlet("/file_reader")
public class LetturaFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String getContattiCSV() throws IOException {
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		String s = getServletContext().getRealPath("/WEB-INF/rubrica_hibernate.csv");
		File f = new File(s);
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String riga;
		Contatto contatto;
		String[] r;
		
		while(br.ready()) {
			riga = br.readLine();
			r = riga.split(";");
			
			contatto = new Contatto();
			contatto.setCognome(r[0]);
			contatto.setNome(r[1]);
			contatto.setEmail(r[2]);
			contatto.setTelefono(r[3]);
			contatto.setNote(r[4]);
			
			contatti.add(contatto);
		}
		
		StringBuilder st = new StringBuilder();
		for(Contatto c : contatti) {
			st.append("<div><h1>"+c.getNome() + " " + c.getCognome() + "</h1>")
			.append("<p>" + " contatto n° " + c.getId() + "<br />" + "numero di telefono: " + c.getTelefono() + "<br />" + "email: " + c.getEmail() + "<br />" + "note: " +c.getNote() + "</p></div>");
		}
		
		return st.toString();
	}
	
	private static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}
		
		return childElements;
	}
	
	private String getContattiXML() throws SAXException, IOException, ParserConfigurationException {
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		String s = getServletContext().getRealPath("/WEB-INF/rubrica.xml");
		File f = new File(s);
		
		Document document = documentBuilder.parse(f);
		
		Element root = document.getDocumentElement(); //rubrica
		
		NodeList childNodes = root.getChildNodes(); //contatto x 2

		for (int i = 0; i < childNodes.getLength(); i++) {
			Contatto contatto = new Contatto();
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				Element el = (Element)node;
				List<Element> values = getChildElements(el); //nome, cognome, email, note, telefono 
				for (Element value : values) { //quando non sappiamo quanti tag ci saranno, è meglio fare un ciclo per scorrerli 
					switch (value.getTagName()) {
					case "nome":
						contatto.setNome(value.getTextContent());
						break;
					case "cognome":
						contatto.setCognome(value.getTextContent());
						break;
					case "telefono":
						contatto.setTelefono(value.getTextContent());
						break;
					case "email":
						contatto.setEmail(value.getTextContent());
						break;
					case "note":
						contatto.setNote(value.getTextContent());
					}
				}
				contatti.add(contatto);
			}
		}
		
		StringBuilder st = new StringBuilder();
		
		for(Contatto c : contatti) {
			st.append("<div><h1>"+c.getNome() + " " + c.getCognome() + "</h1>")
			.append("<p>" + " contatto n° " + c.getId() + "<br />" + "numero di telefono: " + c.getTelefono() + "<br />" + "email: " + c.getEmail() + "<br />" + "note: " +c.getNote() + "</p></div>");
		}
		
		return st.toString();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type_of_file");
		
		String st = null;
		
		switch(type) {
		case "CSV": {
				st = getContattiCSV();
				break;
			}
		case "XML": {
				try {
					st = getContattiXML();
				} catch (SAXException | IOException | ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
				
		response.getWriter().append(st);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
