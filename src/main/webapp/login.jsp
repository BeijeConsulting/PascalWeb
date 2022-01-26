<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<%
String error = (String)session.getAttribute("error");
if (error != null) {
	out.print(error + "<br><br>");
	session.removeAttribute("error");
}
%>

	<form action="immobiliareServlet" method="post" align="center">
	<h2> Login </h2>
	  <label for="username">email:</label><br>
	  <input type="text" name="email"><br>
	  <label for="password">password:</label><br>
	  <input type="text" name="password"><br><br>
	  <input type="submit" value="Submit" name="Login">
	  <input type="submit" value="Registrati" name="Registrazione">
	</form> 

</body>
</html>