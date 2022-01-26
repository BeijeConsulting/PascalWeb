<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalTime"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pascal web jsp</title>
</head>
<body>

<%
System.out.println("hello.jsp");
String nome = (String) session.getAttribute("fname"); //request.getParameter("nome");
%>

Ciao <% out.print(nome != null ? nome.toUpperCase() : "Pascal"); %>!
<br/>Ora sono le <%= LocalTime.now() %>

</body>
</html>