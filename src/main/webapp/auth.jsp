<%@page import="it.beije.pascal.web.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentication JSP</title>
</head>
<body>

<%--
String username = request.getParameter("username");
String password = request.getParameter("password");

if (username != null && password != null) {
	User user = new User();
	user.setUsername(username);
	user.setPassword(password);
	
	session.setAttribute("loggedUser", user);
}

USERNAME = <%= username %><br>
PASSWORD = <%= password %>
--%>

<jsp:useBean id="loggedUser" class="it.beije.pascal.web.User" scope="session"></jsp:useBean>

<jsp:setProperty property="username" name="loggedUser" param="user_name"/>
<jsp:setProperty property="password" name="loggedUser" param="pass_word"/>

USERNAME = <jsp:getProperty property="username" name="loggedUser"/>
PASSWORD = <jsp:getProperty property="password" name="loggedUser"/>

</body>
</html>