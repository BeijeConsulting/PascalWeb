<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.beije.pascal.bean.Annuncio" %>
     <%@page import="it.beije.pascal.bean.Indirizzo" %>
      <%@page import="it.beije.pascal.database.ManagerJPA" %>
    <%@page import="java.util.ArrayList" %>
    <%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>


<body>
<h1>Lista annunci</h1>

 <% List<Annuncio> adlist= (List<Annuncio>) session.getAttribute("list");
 	Indirizzo address = new Indirizzo();
%>
 

<% for(Annuncio a : adlist){%>
<form action = "../dettaglio" method="post"> 
<label name= "annuncio" ><% a.getId(); %></label>
<%
	out.println(a.getTipoAnnuncio()+ " " + a.getTipoImmobile() + " " + a.getMq() + ManagerJPA.getAddress(a.getIndirizzoId()).toString());
	out.println(a.getPrezzo());
	out.println(a.getLocali());
	%>
	</form><br><%
	}

%>

<form action="../index.html" method="get">
<input type="submit" value="Home">
</form>
</body>
</html>