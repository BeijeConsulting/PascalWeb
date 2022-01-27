<%@page import="java.util.List"%>
<%@page import="it.beije.domus.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visual Temp</title>
<h1>Visualizzatore Provvisorio</h1>

</head>
<body>

<%
System.out.println("sono su visual.jsp");
List <Utente> u = (List<Utente>) session.getAttribute("lista"); //request.getParameter("nome");
out.print(u);
%>

<br>
<br>
<form action="../index.html" method="post">

  <input type="submit" value="Torna alla Home"></input>

</form>
<br>
<br>


</body>
</html>