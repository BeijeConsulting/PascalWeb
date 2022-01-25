<%@page import="it.beije.pascal.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
<%
	Contatto c = (Contatto) session.getAttribute("contatto_sel");
	if (c == null) return;
%>
	<form action= "modifica" method="post">
		<label>Nome: </label> 
		<input name= "name"  
				type="text" 
				value="<%= c.getNome()%>" > <br> 
		<label>Cognome:</label> 
		<input name= "lastname" 
				value= "<%= c.getCognome()%>"
				type="text">
		<br> <label>Telefono</label> 
		<input name= "phone" 
				value= "<%=c.getTelefono()%>" 
				type="tel"> <br> 
		<label>Email</label> 
		<input name= "email" 
			value= "<%= c.getEmail()%>"
			type="email"> <br>
		<label>Note</label> 
		<input name= "note" 
				value= "<%= c.getNote()%>"
				type="text"> <br> 
		<input type="submit" value= "Modifica" name="modifica" >
	</form>
</body>
</html>
