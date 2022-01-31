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
<title>Domus</title>

<style>
	body {
		font-family: Arial;
		text-align: center;
	}
	.table-container {
    	margin-top: 40px;
	}
	.table-info {
    	background-color: #11101d;
    	color: white;
    	width: 100%;
    	border-radius: 0px;
    	border: none;
	}
	.table-info th {
   		padding: 20px 30px;
    	text-align: center;
    	border-bottom: solid 1px white;
    	color: white;
	}
	.table-info tr:hover {
    	background-color: #29282c;
	}
	.table-info td {
    	padding: 20px 30px;
    	text-align: center;
    	color: white;
    	border: none;
	}
	.table-info td a {
    	padding: 20px 30px;
    	color: rgb(255, 255, 255);
		text-decoration: underline;
	}
	.table-info td a:hover {
    	text-decoration: none;
	}	
	.table-title {
		margin-top: 60px;
	}
	.btn-home {
		background-color: #11101d;
		padding: 12px;
		color: white;
		border-radius: 5px;
		font-size: 15px;
		cursor: pointer;
		border: none;
		margin: 20px;
	}
	.home-link {
		color: white;
		text-decoration: none;
	}
	.btn-visualizza {
		background-color: black;
		color: white;
		border: 1px solid white;
		border-radius: 3px;
		padding: 10px;
		font-size: 15px;
	}
</style>

</head>
<body>
<h1 align="center">Annunci Salvati</h1>
<%List<Annuncio> annunci = (List<Annuncio>) session.getAttribute("listAnnunci"); %>
<div class="table-container">
<table class="table-info">
		<thead>
			<tr>
				<th>VENDITORE ID</th>
				<th>MQ</th>
				<th>PREZZO</th>
				<th>VISITA GUIDATA</th>
				<th>VIRTUAL TOUR</th>
				<th>CANCELLA</th>
			</tr>
		</thead>

		<tbody>
			<% if(!annunci.isEmpty()) %>
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
						<input class="btn-visualizza" type = "submit" value = "Rimuovi">
					</form>
				</td>	
			</tr>
			<% } %>
		</tbody>
</table>
</div>
<button class="btn-home">
		<a class="home-link" href="domus_home.jsp">Home</a>  
	</button>
</body>
</html>