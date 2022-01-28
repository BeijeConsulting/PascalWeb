
<!--
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<style>
a:link, a:visited {
  background-color: #4CAF50;
  color: white;
  padding: 10px 20px;
  text-align: center;
  border: 1px solid #ccc;
  border-radius: 4px;
  text-decoration: none;
  display: inline-block;
  margin-bottom: 20px;
}

a:hover, a:active {
  background-color: #45a049;
  color: white;
}


body {
	max-width: 850px;
 	margin: auto;
 	font-family: Arial, sans-serif;
}

input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

label {
	font-size: 20px;
}
div {
border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  margin: 10px;
}
</style>
</head>
<body>
	//String nome = (String) session.getAttribute("username");
	//String pass = (String) session.getAttribute("password");
<div>
<h2>Qui puoi lavorare con il database</h2>

<form action="contatti" method="get">
  <p>Vuoi vedere tutti i contatti?</p>
  <input type="submit" value="Clicca qui!">
</form> 
</div>

<div>
<h2>Aggiungi un contatto!</h2>
<form action="contatti" method="post">
	<label for="fist_name">Nome</label>
	<input style="margin:10px" type="text" name="first_name">
	
	<label for="last_name">Cognome</label>
	<input style="margin:10px" type="text" name="last_name"><br />
	
	<label for="tel">Telefono</label>
	<input style="margin:10px" type="text" name="tel">
	
	<label for="email">Email</label>
	<input style="margin:10px" type="text" name="email"><br />
	
	<label for="notes">Note</label>
	<input style="margin:10px" type="text" name="notes"><br />
	
	<input type="submit" value="Aggiungi" />
</form>
</div>

<br />
<a href="file.html">Vuoi leggere qualcosa da file?</a>

-->

<%@page import="it.beije.pascal.web.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOMEPAGE</title>
</head>
<body>

<%--
User user = (User) session.getAttribute("loggedUser");

if (user != null) {
%>
BENTORNATO <%= user.getUsername() %>
<%
} else {
	out.print("UTENTE NON AUTENTICATO!!");
}
--%>

<jsp:useBean id="loggedUser" class="it.beije.pascal.web.User" scope="session"></jsp:useBean>
<%--
User user = (User) session.getAttribute("loggedUser");
if (user == null) {
	user = new User();
	session.setAttribute("loggedUser", user);
}
--%>

<% if (loggedUser.getUsername() != null) { %>
BENTORNATO <jsp:getProperty property="username" name="loggedUser"/>
<% } else {
	out.print("UTENTE NON AUTENTICATO!!");
	}
%>

</body>
</html>