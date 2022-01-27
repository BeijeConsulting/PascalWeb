<%@page import="it.beije.pascal.web.authenticator.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Utente utente = (Utente) request.getSession().getAttribute("utente"); %>
	
	<%if(utente.getUsername() != null) {%>
	
	Benvenuto utente: <%= utente.getUsername() + " " + utente.getPassword() %>
	
	<%} else{
		out.print("Utente non autenticato");
		
	}%>
	
	
	
</body>
</html>