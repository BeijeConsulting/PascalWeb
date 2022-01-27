<%@page import="it.beije.pascal.web.beans.Utente"%>
<%@page import="org.apache.catalina.SessionEvent"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 style="color:brown">Benvenuto in Domus</h1><br>
<%
Utente u = (Utente) session.getAttribute("loggedUser");
%>
Benvenuto! <div style="color: green"><%= u.getEmail() %></div><br>

<h2>Ecco le cose che puoi fare adesso</h2><br>

<h3>Inserire un nuovo annuncio</h3>
<a href="inserisciAnnuncio.jsp">Inserisci annuncio</a><br><br>

<h3>Vedere tutti gli annunci presenti nel sito</h3>
<a href="vediAnnunci.jsp">Vedi annunci</a><br><br>

<h3>Cercare gli annunci che vuoi</h3>


</body>
</html>