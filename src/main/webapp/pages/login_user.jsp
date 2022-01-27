<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<h1>Pagina di Login Utente</h1>
</head>
<body>

<%
String error = (String)session.getAttribute("error");
if (error != null) {
	out.print(error + "<br><br>");
	session.removeAttribute("error");
}
%>

	<form action="loginUser" method="post">
	  <label for="username">username:</label><br>
	  <input type="text" name="user_name"><br>
	  <label for="password">password:</label><br>
	  <input type="text" name="pass_word"><br><br>
	  <input type="submit" value="Submit">
	</form> 

</body>
</html>