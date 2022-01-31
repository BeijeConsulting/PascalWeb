<%@page import="java.util.List"%>
<%@page import="it.beije.pascal.domus.Annuncio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Domus</title>

<style>
	body {
		font-family: Arial;
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
	}
	.home-link {
		color: white;
		text-decoration: none;
	}
</style>

</head>
<body align = "center">
<%List<Annuncio> annunci =(List<Annuncio>) session.getAttribute("annunci"); %>
	
	<form action="salva_ricerca">
	<input type="submit" value="salva ricerca">
	</form>
	
	<h1>Annunci trovati</h1>
	<div class="table-container">
	<table class="table-info">

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
	</div>
	<br />
	<button class="btn-home">
		<a class="home-link" href="domus_home.jsp">Home</a>  
	</button>
</body>
</html>