<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica il contatto</title>
</head>
<body>
	<%
		String nome = (String) session.getAttribute("nome");
		String cognome = (String) session.getAttribute("cognome");
		String tel = (String) session.getAttribute("tel");
		String email = (String) session.getAttribute("email");
		String note = (String) session.getAttribute("note");
	%>
	
	<h1>Modifica il contatto <%= nome %></h1>
	
	<form action="modifica" method="post">
	<label for="fist_name">Nome</label>
	<input style="margin:10px" type="text" name="first_name" value="<%=nome%>">
	
	<label for="last_name">Cognome</label>
	<input style="margin:10px" type="text" name="last_name" value="<%=cognome%>"><br />
	
	<label for="tel">Telefono</label>
	<input style="margin:10px" type="text" name="tel" value="<%=tel%>">
	
	<label for="email">Email</label>
	<input style="margin:10px" type="text" name="email" value="<%=email%>"><br />
	
	<label for="notes">Note</label>
	<input style="margin:10px" type="text" name="notes" value="<%=note%>"><br />
	
	<input type="submit" value="modifica" />
</form>
	
</body>
</html>