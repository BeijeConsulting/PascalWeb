<%@page import="java.util.List"%>
<%@page import="it.beije.pascal.domus.Annuncio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Annuncio> annunci =(List<Annuncio>) session.getAttribute("annunci"); %>

	
</body>
</html>