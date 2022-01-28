<%@page import="it.beije.pascal.web.Contatto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I tuoi contatti</title>
</head>

<style>

body {
	max-width: 850px;
 	margin: auto;
 	font-family: Arial, sans-serif;
}

div {
	border-radius: 5px;
  	background-color: #f2f2f2;
  	padding: 20px;
  	margin: 10px;
}
input[type=submit] {
	background-color: tomato;
	border: none;
	color: white;
	padding: 10px;
	font-size: 15px;
	border-radius: 4px;
	margin: 5px;
}
input[type=submit]:hover {
	cursor: pointer;
}
button {
	background-color: blue;
	border: none;
	color: white;
	padding: 10px;
	font-size: 15px;
	border-radius: 4px;
	margin: 15px;
}
a {
	color: white;
}
</style>

<body>
<% List<Contatto> contatti = (List<Contatto>) session.getAttribute("contatti"); %>

<button>
	<a href="homepage.jsp">Home</a>
</button>

<% for(Contatto c : contatti) { %>
	<div>
		<h1><%= c.getNome() %> <%= c.getCognome() %></h1>
		<p>numero di telefono: <%= c.getTelefono() %>, email: <%= c.getEmail() %> <br /> note: <%= c.getNote() %></p>
		
		<form action="elimina" method="post">
			<input type="hidden" name="Id" value="<%=c.getId()%>" />
			<input type="submit" value="Elimina contatto" />
		</form>
		
		<form action="modifica" method="get">
			<input type="hidden" name="nome" value="<%= c.getNome() %>" />
			<input type="hidden" name="cognome" value="<%= c.getCognome() %>" />
			<input type="hidden" name="tel" value="<%= c.getTelefono() %>" />
			<input type="hidden" name="email" value="<%= c.getEmail() %>" />
			<input type="hidden" name="note" value="<%= c.getNote() %>" />
			<input type="submit" value="Modifica contatto" />
		</form>
	</div>
	<% } %>	
</body>
</html>