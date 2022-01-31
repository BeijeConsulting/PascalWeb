<%@page import="it.beije.pascal.bean.Utente"%>
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
<% out.println("Tipo annuncio: " + a.getTipoAnnuncio()); %> <br>
	<%=("Tipo immobile: " + a.getTipoImmobile())  %> <br>
	<%=("Metri quadrati: " + a.getMq()) %> <br>
	<%=(ManagerJPA.getAddress(a.getIndirizzoId()).printAddress()) %> <br>
	<%=("Prezzo: " + a.getPrezzo()) %> <br>
	<%=("Numero di locali: " + a.getLocali()) %>
	
	</form><br><%
	}

%>

<% Utente u = (Utente)session.getAttribute("loggedUser");
String s;
if(u.isAmministratore()){
	s = "personal_page_admin.jsp";
}
else{
	s = "personal_page.jsp";
}
	
%>

<form action="<%= s %>" method="get">
<input type="submit" value="Home">
</form>
</body>
</html>