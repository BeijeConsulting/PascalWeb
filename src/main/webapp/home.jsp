<%@page import="it.beije.pascal.web.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOMEPAGE</title>
</head>
<body>

<jsp:useBean id="loggedUser" class="it.beije.pascal.bean.Utente" scope="session"></jsp:useBean>

<%
if (loggedUser.getUsername() != null) {
%>
BENTORNATO <jsp:getProperty property="username" name="loggedUser"/>
<%
} else {
	out.print("UTENTE NON AUTENTICATO!!");
}
%>

</body>
</html>