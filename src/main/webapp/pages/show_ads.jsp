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
<% List<Annuncio> adlist= (List<Annuncio>) session.getAttribute("list");%>
<% Utente u = (Utente)session.getAttribute("loggedUser");%>
<% for(Annuncio a : adlist){%>
<fieldset>
<% out.println("Tipo annuncio: " + a.getTipoAnnuncio()); %> <br>
    <%=("Tipo immobile: " + a.getTipoImmobile())  %> <br>
    <%=("Metri quadrati: " + a.getMq()) %> <br>
    <%=(ManagerJPA.getAddress(a.getIndirizzoId()).printAddress()) %> <br>
    <%=("Prezzo: " + a.getPrezzo()) %> <br>
    <%=("Numero di locali: " + a.getLocali()) %>
    <% if(u.isAmministratore()){ %>
    <form action = "../delete" method="post">
    <input type="submit" value = "Cancella Annuncio" style="float: right;">
    </form>
    <%} %>
    <form action = "../addpreferito" method="post">
    <input name="annuncio" value="<%= a.getId() %>" type="hidden">
    <input name="utente" value="<%= u.getId() %>" type="hidden">
    <input type="submit" value = "Aggiungi ai preferiti" style="float: right;">
    </form>
    <form action = "../getdetails" method="post"> 
    <input name="annuncio" value="<%= a.getId() %>" type="hidden">
    <input type="submit" value = "Vedi" style="float: right;">
    </form>
    </fieldset><br><%
    }
%>
<% 
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