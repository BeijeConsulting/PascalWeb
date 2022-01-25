package it.beije.pascal.web.util;

import java.util.List;

import it.beije.pascal.rubrica.Contatto;

public class ContattoWebUtil {
	public static String tabellaContattiHtml(List<Contatto> contatti) {
		StringBuilder sb = new StringBuilder();
		sb.append("<table>\r\n"
				+ "  <tr>\r\n"
				+ "    <th>ID</th>\r\n"
				+ "    <th>Nome</th>\r\n"
				+ "    <th>Cognome</th>\r\n"
				+ "    <th>Telefono</th>\r\n"
				+ "    <th>Email</th>\r\n"
				+ "    <th>Note</th>\r\n"
				+ "  </tr>\r\n");
		
		for (Contatto c : contatti) {
			sb.append("  <tr>\r\n"
					+ "<td>" + c.getId() 		+ "</td>" 
					+ "<td>" + c.getNome() 		+ "</td>" 
					+ "<td>" + c.getCognome() 	+ "</td>" 
					+ "<td>" + c.getTelefono() 	+ "</td>" 
					+ "<td>" + c.getEmail() 	+ "</td>" 
					+ "<td>" + c.getNote() 		+ "</td>"
					+ "	</tr>\r\n" );
		}
		
		return sb.append("</table>").toString();
	}
}
