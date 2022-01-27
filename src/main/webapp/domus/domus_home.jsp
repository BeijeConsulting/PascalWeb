<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="it.beije.pascal.domus.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="logged_user" class="it.beije.pascal.domus.Utente" scope="session"></jsp:useBean>
<br>
<%if(((Utente)session.getAttribute("logged_user")).getEmail()!= null ){%>
<jsp:setProperty property="email" name="logged_user" param="email_logged"/>
Welcome 
<jsp:getProperty property="email" name="logged_user"/>
<form action="logout" method="post">
<input type="submit" value="Logout">
</form>
<br>
<a href="crea_annuncio.jsp">Crea nuovo annuncio</a>

<%}else {%>
<a href="domus_login.html">Login</a>  
<a href="domus_registration.jsp">Registrazione</a>
<%} %>

<div id="azioni_chiunque">
<form action="ricerca">

</form>
</div>
</body>
</html>