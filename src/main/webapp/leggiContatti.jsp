
<%@page import="it.beije.pascal.web.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style="background-color: lightblue; padding: 30px; font-size: 20px; border: 1px solid black; border-radius: 10px; font-weight: bold">
<% 
Contatto contact = (Contatto)session.getAttribute("contatto");
out.print(contact);
%>
</div>
<p style="color: green; font-size:20px; font-weight: bold; text-align: center">Complimenti! Il contatto è stato aggiunto!</p>

<form action="LeggiJDBC">
<label>Clicca per vedere l'elenco completo</label>
<input type="submit">
</form>

</body>
</html>