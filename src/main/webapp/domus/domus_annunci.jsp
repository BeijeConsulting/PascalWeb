<%@page import="java.util.List"%>
<%@page import="it.beije.pascal.domus.Annuncio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align = "center">
<%List<Annuncio> annunci =(List<Annuncio>) session.getAttribute("annunci"); %>

	<h1>Annunci trovati</h1>
	<table border = 2 align = "center" >

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
				
			</tr>
			<% } %>

		</tbody>

	</table>
	<br>
	<a href = "domus_home.jsp" >Home</a>
	
</body>
</html>