<%@page import="org.hibernate.internal.build.AllowSysOut"%>
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
<jsp:setProperty property="email" name="logged_user" param="email_logged"/>
<br>

<%if(session.getAttribute("logged_user")!= null ){%>
Welcome 
<jsp:getProperty property="email" name="logged_user"/>
<a href="/logout">logout</a>
<br>
<%}else {%>
<a href="domus_login.html">Login</a>
     
<a href="domus_registration.jsp">Registrazione</a>
<%} %>
<a href="crea_annuncio.jsp">Crea nuovo annuncio</a>
</body>
</html>