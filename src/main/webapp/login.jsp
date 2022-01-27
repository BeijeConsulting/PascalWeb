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
	//se nella sessione si crea un errore lo vedrò qui e lo stamperò in questa pagina
	String error = (String) session.getAttribute("error");
	if (error != null) {
		out.print(error + "<br><br>");
		//uso questo metodo per togliere error dalla session altrimenti ogni volta rimane stampato l'errore
		session.removeAttribute("error");
	}
	%>

	<!-- In questo form chiamiamo la servlet login -->
	<!-- Passiamo un username e password con nome diverso dalla bean convention ma rimediamo con il param="" di la -->
	<form action="login" method="post">
		<label for="username">username:</label><br> 
		<input type="text" name="user_name"><br> 
		<label for="password">password:</label><br>
		<input type="text" name="pass_word"><br>
		<br> <input type="submit" value="Submit">
	</form>

</body>
</html>