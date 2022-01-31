<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="it.beije.pascal.domus.Utente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Domus</title>
</head>
<style>
body {
	max-width: 850px;
 	margin: auto;
 	font-family: Arial;
}
.annuncio-container {
	border-radius: 10px;
	border: 2px solid black;
	padding: 30px;
	color: white;
	background-color: #11101d;
}
.annuncio-container h1 {
	border-bottom: 2px solid white;
}
.annuncio-container form {
	margin-bottom: 20px;
}
.commento {
	border: none;
	padding: 8px;
	background: #29282c;
	border-radius: 5px;
	color: white;
}
.btn-home {
		background-color: #11101d;
		padding: 12px;
		color: white;
		border-radius: 5px;
		font-size: 15px;
		cursor: pointer;
		border: none;
	}
	.home-link {
		color: white;
		text-decoration: none;
	}

</style>
<body>

<jsp:useBean id="indirizzo" class="it.beije.pascal.domus.Indirizzo" scope="session"></jsp:useBean>
<jsp:useBean id="annuncio" class="it.beije.pascal.domus.Annuncio" scope="session"></jsp:useBean>
<br>


<div class="annuncio-container">
		<h1><%= annuncio.getTipoAnnuncio() %> <%= annuncio.getTipoImmobile() %></h1>
		<p><b>METRI QUADRI:</b> <%= annuncio.getMq() %> <br /> <b>PREZZO:</b> <%= annuncio.getPrezzo() %> <br /> <b>DESCRIZIONE:</b> <%= annuncio.getDescrizioneLunga() %></p>
		<p><b>INDIRIZZO:</b> <%= indirizzo.getIndirizzo() %> <br /> <b>COMUNE:</b> <%= indirizzo.getComune()%> <br /> <b>CAP:</b> <%= indirizzo.getCap() %></p>
		<form action="salvataggio" method="post">
			<input type="hidden" name="annuncioId" value="<%=annuncio.getId()%>" />
				<label><b>commento:</b> </label> <input class="commento" name="commento" type="text"> <br>
			
			<%if(((Utente)session.getAttribute("logged_user")).getEmail()!= null ){%>
			<input type="submit" value="Salva preferiti" />
			<%}%>
		</form>
		
</div>

<br />
<br />
	<button class="btn-home">
		<a class="home-link" href="domus_home.jsp">Home</a>  
	</button>

</body>
</html>