<%@page import="it.beije.pascal.immobiliare.Utente"%>
<%@page import="it.beije.pascal.immobiliare.Util"%>
<%@page import="it.beije.pascal.immobiliare.Annuncio"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOMEPAGE</title>
</head>
<body>

<jsp:useBean id="utente" class="it.beije.pascal.immobiliare.Utente" scope="session"></jsp:useBean>
<%
if (utente.getUsername() != null) {
%>
BENTORNATO <jsp:getProperty property="username" name="utente"/>
<%
} else {
	out.print("UTENTE NON AUTENTICATO!!");
}
%>



<div align="center">
		<table border="2" width="1" cellspacing="1" cellpadding="2">
			<thead>
				<tr>
					<th>id</th>
					<th>gescrizione</th>
					<th>prezzo</th>
					<th>mq</th>

				</tr>
			</thead>

			<tbody>
				<%
				List<Annuncio> annunci = Util.allAnnunci();
				if(annunci.size() != 0) {
				for (Annuncio ann : annunci) {
				%>
				<tr>
					<td><%=ann.getId()%></td>
					<td><%=ann.getDescrizioneLunga()%></td>
					<td><%=ann.getPrezzo()%></td>
					<td><%=ann.getMq()%></td>
				</tr>
				<%
				}
				}else{
					
				}
				%>
			</tbody>
		</table>
		<br>
	</div>





</body>
</html>