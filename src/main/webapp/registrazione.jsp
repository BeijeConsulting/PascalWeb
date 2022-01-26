<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>

	<form action="immobiliareServlet" method="post" align="center">
	<h2> Login </h2>	
	  <label for="username">email:</label><br>
	  <input type="text" name="email"><br>
	  <label for="password">password:</label><br>
	  <input type="text" name="password"><br><br>
	   <label for="password">avatarUrl:</label><br>
	  <input type="text" name="avatarUrl"><br><br>
	  <label for="password">spam check:</label><br>
	  <input type="text" name="spam_check"><br><br>
	   <label for="password">username:</label><br>
	  <input type="text" name="username"><br><br>
	  <input type="submit" value="Submit" name="newUtente">
	  </form>
</body>
</html>