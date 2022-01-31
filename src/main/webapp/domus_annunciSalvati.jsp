<%@page import="it.beije.pascal.domus.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.beije.pascal.domus.Annuncio"%>
<%@page import="it.beije.pascal.domus.GestioneAnnuncio"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Annunci Salvati</h1>
<%List<Annuncio> annunci = (List<Annuncio>) session.getAttribute("listAnnunci"); %>
<table border = 1 align = "center" >
		<thead>
			<tr>
				<th>Venditore id</th>
				<th>Mq</th>
				<th>Prezzo</th>
				<th>Visita guidata</th>
				<th>Virtual tour</th>
			</tr>
		</thead>

		<tbody>
			<% for (Annuncio annuncio : annunci) {	%>
			<tr>
				<td><%= annuncio.getVenditoriId() %></td>
				<td><%= annuncio.getMq() %></td>
				<td><%= annuncio.getPrezzo() %></td>
				<td><%= annuncio.isVisitaGuidata() %></td>
				<td><%= annuncio.isVirtualTour() %></td>	
				<td>
					<form action = "remove_annuncio_salvato" method = "post">
						<input type = "hidden" value = "<%= annuncio.getId() %>" name = "annuncioId">
						<input type = "hidden" value = "<%= ((Utente)session.getAttribute("logged_user")).getId() %>" name = "utenteId">
						<input type = "submit" value = "Rimuovi">
					</form>
				</td>	
			</tr>
			<% } %>

		</tbody>
</table>
</body>
</html>