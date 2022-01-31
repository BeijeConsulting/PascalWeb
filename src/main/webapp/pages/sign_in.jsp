<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
</head>
<body>
<h1>Pagina di Registrazione Utente</h1>
<form action="..\register" method="post">
	  <label for="username">username:</label><br>
	  <input type="text" name="user_name"><br>
	  <label for="email">email:</label><br>
	  <input type="text" name="email"><br>
	  <label for="password">password:</label><br>
	  <input type="password" name="pass_word"><br><br>
	  
	  <label for="spam">Desideri rimanere aggiornato sulle ultime novità di fondamenta.it?</label>
	  <input type="checkbox" name="spam"><br><br>
	  
	  <input type="submit" value="Registra">
	</form>
</body>
</html>