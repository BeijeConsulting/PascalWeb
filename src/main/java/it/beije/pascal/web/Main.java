package it.beije.pascal.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.beije.pascal.web.Contatto;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		//provenienti dalla libreria java.xml.parser
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document d = db.parse("C:\\Users\\Padawan01\\OneDrive\\Desktop\\andrea.xml.txt");
		
			Element root = d.getDocumentElement();
			System.out.println(root.getTagName());
			
			NodeList contatti = root .getElementsByTagName("contatto");
			for (int i = 0; i < contatti.getLength(); i++) {
				Element contatto = (Element)contatti.item(i);	
				System.out.println("contatto " + i + " : " + contatto.getAttribute("età"));
			}
			
			NodeList childNodes = root.getChildNodes();
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node node = childNodes.item(i);
				if (node instanceof Element) {
					Element el = (Element)node;
					
					System.out.println("Contatto " + i + " : " + el.getTextContent());
				}
			}
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
