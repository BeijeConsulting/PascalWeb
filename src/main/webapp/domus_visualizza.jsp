<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="it.beije.pascal.domus.Utente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	max-width: 850px;
 	margin: auto;
 	font-family: Arial, sans-serif;
}
div {
	border-radius: 5px;
  	background-color: #F2F2F2;
  	padding: 20px;
  	margin: 10px;
}
input[type=submit] {
	background-color: tomato;
	border: none;
	color: white;
	padding: 10px;
	font-size: 15px;
	border-radius: 4px;
	margin: 5px;
}
input[type=submit]:hover {
	cursor: pointer;
}
button {
	background-color: blue;
	border: none;
	color: white;
	padding: 10px;
	font-size: 15px;
	border-radius: 4px;
	margin: 15px;
}
a {
	color: black;
}
</style>
<body>

<jsp:useBean id="indirizzo" class="it.beije.pascal.domus.Indirizzo" scope="session"></jsp:useBean>
<jsp:useBean id="annuncio" class="it.beije.pascal.domus.Annuncio" scope="session"></jsp:useBean>
<br>


<div>
		<h1><%= annuncio.getTipoAnnuncio() %> <%= annuncio.getTipoImmobile() %></h1>
		<p>metri quadri: <%= annuncio.getMq() %>, prezzo: <%= annuncio.getPrezzo() %> <br /> descrizione: <%= annuncio.getDescrizioneLunga() %></p>
		<p>Indirizzo: <%= indirizzo.getIndirizzo() %>, Comune: <%= indirizzo.getComune()%> <br /> cap: <%= indirizzo.getCap() %></p>
		<form action="salvataggio" method="post">
			<input type="hidden" name="annuncioId" value="<%=annuncio.getId()%>" />
				<label>commento: </label> <input name="commento" type="text"> <br>
			
			<%if(((Utente)session.getAttribute("logged_user")).getEmail()!= null ){%>
			<input type="submit" value="Salva preferiti" />
			<%}%>
		</form>
		
</div>

<a href="domus_home.jsp"> Home </a>

</body>
</html>