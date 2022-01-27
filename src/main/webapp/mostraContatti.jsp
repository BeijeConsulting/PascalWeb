<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="it.beije.pascal.web.esercizi.Contatto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	List<Contatto> contatti = (ArrayList) session.getAttribute("contatti");
	for (Contatto c : contatti) {
	%>

	<div
		style="background-color: lightblue; padding: 30px; font-size: 20px; border: 1px solid black; border-radius: 10px; font-weight: bold">

		<%
		out.print(c);
		%>


	</div>

	<br>
	<br>


	<%
	}
	%>




</body>
</html>