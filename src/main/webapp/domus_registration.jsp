<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Domus</title>
</head>
<body>

<form action="register_user" method="post">
<fieldset>
<legend>Registrazione</legend>
	<label>email:	</label>
	<input type="email" name="email">
	<br>
	<label>password:</label>
	<input type="password" name="password">
	<br>
	<label>Acconsento al trattamento dei dati: </label>
	<br><input type="checkbox" name="spam_check">
	<br>
	<input type="submit" value="Registrati">
</fieldset>
</form>

</body>
</html>