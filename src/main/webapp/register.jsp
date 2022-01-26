<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registrati</h1>

<form action="dbregister" method="post">
    <label >Email:</label><br/>
	<input type="email" name="email"><br/>
	<label >Password:</label><br/>
	<input type="text"  name="password"><br/>
	<label >Username:</label><br/>
	<input type="text"  name="username"><br/>
	<input type="submit" value="Aggiungi">
</form>

</body>
</html>