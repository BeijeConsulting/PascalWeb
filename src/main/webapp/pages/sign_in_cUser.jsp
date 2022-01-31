<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign in</title>
</head>
<body>
<h1>Pagina di Registrazione Utente Commerciale</h1>

<p style="color:red">
<%
String error = (String)session.getAttribute("error");
if (error != null) {
	//JOptionPane.showMessageDialog(null, error);
	out.print(error + "<br><br>");
	session.removeAttribute("error");
}
%>
</p>

<form action="..\registerCommercialUser" method="post">

	  <label for="username">Username:</label><br>
	  <input type="text" name="user_name"><br>
	  
	  <label for="email">Email:</label><br>
	  <input type="text" name="email"><br>
	  
	  <label for="password">Password:</label><br>
	  <input type="password" name="pass_word"><br><br>
	  
	  <label for="agenzia">Ragione sociale agenzia:</label><br>
	  <input type="text" name="agenzia"><br><br>
	  
	  <label for="spam">Desideri rimanere aggiornato sulle ultime novità di fondamenta.it?</label>
	  <input type="checkbox" name="spam"><br><br>
	  
	  <input type="submit" value="Registra">
	  
	</form>
</body>
</html>