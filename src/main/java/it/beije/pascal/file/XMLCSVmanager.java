package it.beije.pascal.file;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XMLCSVmanager {
	
	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}
		return childElements;
	}
	
	public static void printContatti(List<Contatto> listContatto) {
		for(Contatto c: listContatto) {
			System.out.println(c.toString());
		}
	}
	
	
	private static String getTextValue(String def, Element doc, String tag) {
		 String value = def;
		 NodeList nl;
		 nl = doc.getElementsByTagName(tag);
		 if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
		   value = nl.item(0).getFirstChild().getNodeValue();
		 }
		 return value;
		}
	
	
	public static Contatto searchContatto(List<Contatto> listcont, String surname) {
		for (Contatto c: listcont) {
			if(c.getCognome() == surname) {
				return c;
			}
		}
		return null;
	}
	
	public static boolean isContatto(List<Contatto> listcont, String cognome) {
		for (Contatto c: listcont) {
			if(c.getCognome() == cognome) {
				return true;
			}
		}
		return false;
	}
	
	
	public static List<Contatto> loadRubricaFromCSV(InputStream file) throws IOException {
		List<Contatto> rows = new ArrayList<>();
		boolean firstLine = true;
		
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		String result = null;
		String[] r;
			Scanner s= new Scanner(file);
			//result = s.next();
			//System.out.println(result);
			while(s.hasNext()) {
				Contatto c = new Contatto();
				result = s.nextLine();
				r = result.split(";",-1);
				c.setCognome(r[0]);
				c.setNome(r[1]);
				c.setEmail(r[2]);
				c.setTelefono(r[3]);
				rows.add(c);
			}
//			String row;
//			Contatto contatto;
//			String[] r;
//			int posCog=0, posNom=0, posTel=0, posEm=0, posNot=0;
//			
//			if(firstLine) {
//				row = bufferedReader.readLine();
//				r = row.split(sep);
//				contatto = new Contatto();
//				for( int i =0; i < r.length; i++) {
//					if(r[i].equalsIgnoreCase("COGNOME")) {contatto.setCognome(r[i]); posCog = i;}
//					if(r[i].equalsIgnoreCase("NOME")) {contatto.setNome(r[i]); posNom = i;}
//					if(r[i].equalsIgnoreCase("TELEFONO")) {contatto.setTelefono(r[i]); posTel = i;}
//					if(r[i].equalsIgnoreCase("EMAIL")) {contatto.setEmail(r[i]); posEm = i;}
//				}
//				firstLine = false;
//			}
//			while (bufferedReader.ready()) {
//				row = bufferedReader.readLine();
//			
//				r = row.split(sep,-1);
//				contatto = new Contatto();
//				contatto.setCognome(r[posCog]);
//				contatto.setNome(r[posNom]);
//				contatto.setTelefono(r[posTel]);
//				contatto.setEmail(r[posEm]);
//				
//				System.out.println(contatto);
//				
//				rows.add(contatto);
//				}
//		} catch (IOException ioEx) {
//			ioEx.printStackTrace();
//			throw ioEx;
//		} finally {
//			try {
//				if (bufferedReader != null) {
//					bufferedReader.close();
//				}
//				if (reader != null) {
//					reader.close();
//				}
//			} catch (Exception fEx) {
//				fEx.printStackTrace();
//			}
//		}
		return rows;
	}
	
	
	public static List<Contatto> loadRubricaFromXML(InputStream file)  throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		List<Contatto> contactList = new ArrayList<Contatto>();
		Document document = documentBuilder.parse(file);
		String name=null;
		String surname=null;
		String tel=null;
		String email=null;
		String note=null;
		
		Element root = document.getDocumentElement();
		//System.out.println("root : " + root.getTagName());
		NodeList contatti = root.getElementsByTagName("contatto");
		/*
		 * for (int i = 0; i < contatti.getLength(); i++) { Element contatto =
		 * (Element)contatti.item(i); System.out.println("contatto " + i + " : " +
		 * contatto.getAttribute("eta")); }
		 */
		NodeList childNodes = root.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				Element el = (Element)node;
				Contatto contatto = new Contatto();
				name= getTextValue(name, el, "nome");
				contatto.setNome(name);
				surname= getTextValue(surname, el, "cognome");
				contatto.setCognome(surname);
				tel= getTextValue(tel, el, "telefono");
				contatto.setTelefono(tel);
				email= getTextValue(email, el, "email");
				contatto.setEmail(email);
				note= getTextValue(note, el, "note");
				contatto.setNote(note);
				contactList.add(contatto);
				
//				List<Element> values = getChildElements(el);
//				for (Element value : values) {
//					System.out.println(value.getTagName() + " : " + value.getTextContent());
//				}
			}
		}
		return contactList;
	}
	
	
	public static void writeRubricaXML(List<Contatto> contatti, String pathFile) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Document doc = documentBuilder.newDocument();
		Element contattis = doc.createElement("contatti");
		doc.appendChild(contattis);
		for(Contatto c : contatti) {

		Element contatto = doc.createElement("contatto");
		//contatto.setAttribute("eta", "35");
		
		Element cognome = doc.createElement("cognome");
		cognome.setTextContent(c.getCognome());
		contatto.appendChild(cognome);

		Element nome = doc.createElement("nome");
		nome.setTextContent(c.getNome());
		contatto.appendChild(nome);

		Element telefono = doc.createElement("telefono");
		telefono.setTextContent(c.getTelefono());
		contatto.appendChild(telefono);

		Element email = doc.createElement("email");
		email.setTextContent(c.getEmail());
		contatto.appendChild(email);

		Element note = doc.createElement("note");
		note.setTextContent(c.getNote());
		contatto.appendChild(note);
		
		contattis.appendChild(contatto);
		
		}
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		StreamResult result = new StreamResult(new File(pathFile));

		// Output to console for testing
		//StreamResult syso = new StreamResult(System.out);

		transformer.transform(source, result);
		//transformer.transform(source, syso);
	}
	 
	 
		private static void writeFile(File file, List<String> rows) {
			FileWriter writer = null;
			List<String> rows2 = rows;
			try {
			writer = new FileWriter(file);
			
			for (String r : rows) {
				String[] c = r.split("\t");
				
				StringBuilder newRow = new StringBuilder(c[0]).append(';')
						.append(c[1]).append(';')
						.append(c[2]).append(';')
						.append(c[3]).append('\n');
				
				writer.write(newRow.toString());
			}
			writer.flush();
			
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			}
		}

		private static void addContatto(List<Contatto> listcont) {
			Contatto cont = new Contatto();
			Scanner s = new Scanner(System.in);
			String st = null;
			
			System.out.println("Inserisci cognome:");
			st = s.next();//aggiunge cognome
			cont.setCognome(st);
			
			System.out.println("Inserisci nome:");
			st = s.next();// aggiunge nome
			cont.setNome(st);
			
			System.out.println("Inserisci telefono:");
			st = s.next();// aggiunge telefono
			cont.setTelefono(st);
			
			System.out.println("Inserisci e-mail:");
			st = s.next(); // aggiunge email
			cont.setEmail(st);
			
			System.out.println("Inserisci descrizione:");
			st = s.next(); //aggiunge note
			cont.setNote(st);
			s.close();
			
			listcont.add(cont);
		}
		
		
		private static void modifyContatto(List<Contatto> listcont, String cognome) {
			Scanner s = new Scanner(System.in);
			String st = null;
			boolean exist = isContatto(listcont, cognome);
			Contatto cont = searchContatto(listcont, cognome);
			
			
			if(exist) {
				System.out.println("Contatto trovato! Inserire modifiche:");

				System.out.println("Inserisci nome: ");
				st= s.next();
				cont.setNome(st);
				
				System.out.println("Inserisci cognome: ");
				st= s.next();
				cont.setCognome(st);
				
				System.out.println("Inserisci telefono: ");
				st= s.next();
				cont.setTelefono(st);
				
				System.out.println("Inserisci email: ");
				st= s.next();
				cont.setEmail(st);
				
				System.out.println("Inserisci note: ");
				st= s.next();
				cont.setNote(st);
			}
		}
		
		
	private static void removeContatto(List<Contatto> listcont, String cognome) {	
		boolean exists = isContatto(listcont, cognome);
		Contatto cont = searchContatto(listcont, cognome);
		listcont.remove(cont);
	}
	
	
	/*
	 * private static String findDuplicateContatti(List<Contatto> listcont) {
	 * List<Contatto> duplicatecont = new ArrayList<Contatto>(); //int cont = 0;
	 * Contatto dupc; for (Contatto c: listcont) { dupc = c; for(Contatto cc :
	 * listcont) { if(dupc == cc) { duplicatecont.add(dupc); break; } } }
	 * if(duplicatecont.isEmpty()) return "Non esistono contatti duplicati"; else
	 * return duplicatecont.toString(); }
	 */
	
	
	public static void mergeContatti(List<Contatto> dupcont, List<Contatto> listcontatto) {
		Scanner sc = new Scanner(System.in);
		String st = null;
		int choice = sc.nextInt();
		boolean quit = false;
		
		System.out.println("Menu' unione duplicati");
		
		while(!quit) {
			System.out.println("\n");
			System.out.println("0: Scrivi il cognome del contatto da unire e stampalo");
			System.out.println("1: Unisci n. di telefono");
			System.out.println("2: Unisci e-mail");
			System.out.println("3: Unisci note");
			System.out.println("4: Stampa lista contatti duplicati");
			System.out.println("5: Torna al menu principale");
			
			switch(choice) {
			case 0:
				st = sc.next();
				Contatto c = searchContatto(dupcont, st);
				System.out.println(c.toString());
				break;
			case 5: 
				quit = true;
				break;
			}
		}
	}

		
/*
	public static void main(String[] args) {
		String fileXML = "C:/Users/franc/git/Pascal/rubrica.xml";
		String fileCSV = "C:/Users/franc/git/Pascal/rubrica.csv";
		String newFileXML = "C:/Users/franc/git/Pascal/rubrica2.xml";
		String newFileCSV = "C:/Users/franc/git/Pascal/rubrica2.csv";
		
		List<Contatto> XMLcontact = new ArrayList<Contatto>();
		List<Contatto> CSVcontact = new ArrayList<Contatto>();
		//RubricaCSV rb = new RubricaCSV();
		/*
		 * try { CSVcontact = RubricaCSV.loadRubricaFromCSV(fileCSV, "\t"); } catch
		 * (IOException e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
		 * try { XMLcontact = loadRubricaFromXML(fileXML); } catch (Exception e) {
		 * System.out.println("Sees"); e.printStackTrace(); } try {
		 * writeRubricaXML(XMLcontact, newFileXML); } catch
		 * (ParserConfigurationException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (TransformerException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } List<Contatto> soscont= new
		 * ArrayList<Contatto>(); //addContatto(soscont); printContatti(CSVcontact);
		 */
}

