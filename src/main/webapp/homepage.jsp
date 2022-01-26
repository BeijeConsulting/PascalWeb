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

<%--
User user = (User) session.getAttribute("loggedUser");

if (user != null) {
%>
BENTORNATO <%= user.getUsername() %>
<%
} else {
	out.print("UTENTE NON AUTENTICATO!!");
}
--%>

<jsp:useBean id="loggedUser" class="it.beije.pascal.web.User" scope="session"></jsp:useBean>
<%--
User user = (User) session.getAttribute("loggedUser");
if (user == null) {
	user = new User();
	session.setAttribute("loggedUser", user);
}
--%>

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