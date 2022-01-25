<%@page import="it.beije.pascal.web.tabella.bean.Contatto"%>
<%@page import="it.beije.pascal.web.tabella.query.Sql"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<% int id = Integer.parseInt(request.getParameter("id")); %>
	<% Contatto contatto = Sql.findById(id); %>
<body>
	<form action="update">
		<input type = "hidden" name = "id" value = "<%= id %>">
		<br>
		<label>Nome: <input type = "text" name = "nome" value = "<%= contatto.getNome() %>"></label>
		<br>
		<label>Cognome: <input type = "text" name = "cognome" value = "<%= contatto.getCognome() %>"></label>
		<br>
		<label>Telefono: <input type = "text" name = "telefono" value = "<%= contatto.getTelefono() %>"></label>
		<br>
		<label>Email: <input type = "text" name = "email" value = "<%= contatto.getEmail() %>"></label>
		<br>
		<label>Note: <input type = "text" name = "note" value = "<%= contatto.getNote() %>"></label>
		<br>
		<input type = "submit" name = "submit" value = "aggiorna">
	</form>
</body>
</html>