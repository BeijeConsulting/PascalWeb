<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage di : <% String nome = (String)session.getAttribute("username"); out.print(nome); %></title>
</head>
<body>
<h2>Benvenuto nella tua pagina!</h2>
<h3>Prego, seleziona una delle opzioni:</h3>

<form action="file.html" method="post">
  <input type="submit" value="Leggi da file"><br><br>
</form> 

<form action="dbget" method="post">
  <input type="submit" value="leggi da DB"><br><br>
</form> 

<form action="fileservlet" method="post">
  <input type="submit" value="Inserisci un contatto"><br><br>
</form> 
</body>
</html>