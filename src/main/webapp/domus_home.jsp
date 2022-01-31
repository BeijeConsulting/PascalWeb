<%@page import="it.beije.pascal.domus.Annuncio"%>
<%@page import="it.beije.pascal.domus.GestioneAnnuncio"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="it.beije.pascal.domus.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
	body {
		font-family: Arial;
	}
	.table-container {
    	margin-top: 40px;
	}
	.table-info {
    	background-color: #11101d;
    	color: white;
    	width: 100%;
    	border-radius: 0px;
    	border: none;
	}
	.table-info th {
   		padding: 20px 30px;
    	text-align: center;
    	border-bottom: solid 1px white;
    	color: white;
	}
	.table-info tr:hover {
    	background-color: #29282c;
	}
	.table-info td {
    	padding: 20px 30px;
    	text-align: center;
    	color: white;
    	border: none;
	}
	.table-info td a {
    	padding: 20px 30px;
    	color: rgb(255, 255, 255);
		text-decoration: underline;
	}
	.table-info td a:hover {
    	text-decoration: none;
	}	
	.table-title {
		margin-top: 60px;
	}
	.btn-visualizza {
		background-color: black;
		color: white;
		border: 1px solid white;
		border-radius: 3px;
		padding: 10px;
		font-size: 15px;
	}
	.form-container {
	}
	.form-container select {
  		border: none;
  		border-bottom: 2px solid black;
		padding: 10px;
		font-size: 15px;
	}
	.form-container label {
		margin-left: 50px;
	}
	.btn-cerca {
		margin-left: 70px;
		background-color: #11101d;
		padding: 12px;
		color: white;
		border-radius: 5px;
		font-size: 15px;
		cursor: pointer;
		border: none;
	}
	.btn-cerca:hover {
		background-color: #29282c;
	}
	.btn-login-reg {
		margin-left: 70px;
		background-color: #11101d;
		padding: 12px;
		color: white;
		border-radius: 5px;
		font-size: 15px;
		cursor: pointer;
		border: none;
	}
	.login-reg-link {
		color: white;
		text-decoration: none;
	}
	
</style>

</head>
<body align = "center">

<jsp:useBean id="logged_user" class="it.beije.pascal.domus.Utente" scope="session"></jsp:useBean>
<br>
<%if(((Utente)session.getAttribute("logged_user")).getEmail()!= null ){%>
Welcome <jsp:setProperty property="email" name="logged_user" param="email_logged"/>
 
<jsp:getProperty property="email" name="logged_user"/>
<form action="logout" method="post">
<input type="submit" value="Logout">
</form>
<br />


<%}else {%>
<button class="btn-login-reg">
	<a class="login-reg-link" href="domus_login.html">Login</a>  
</button>
<button class="btn-login-reg">
	<a class="login-reg-link" href="domus_registration.jsp">Registrazione</a>
</button>


<%} %>

<br />
<br />
<br />
<div class="form-container">
<form action = "ricerca" method = "get">
	<label for = "tipoImmobile"><b>Cerco</b></label>
		<select name = "tipoImmobile" onchange="javascript:handleSelect(this)">			
			<option>Casa</option>		
			<option>Nuova costruzione</option>
			<option>Immobile o attività commerciale</option>				
			<option>Terreno</option>	
			<option>Garage o posto auto</option>				
		</select>
		
	<label for = "tipoAnnuncio"><b>In</b></label>
		<select name = "tipoAnnuncio">
			<option>Vendita</option>		
			<option>Affitto</option>	
			<option>Affitto breve</option>			
		</select>
		
	<label for = "comune"><b>a</b></label>
		<select name = "comune">
			<option>Milano</option>		
			<option>Vercelli</option>	
			<option>Roma</option>	
			<option>Genova</option>		
			<option>Torino</option>
			<option>Firenze</option>		
			<option>Bologna</option>
			<option>Napoli</option>			
		</select>
	<input class="btn-cerca" type = "submit" value = "CERCA">
</form>
</div>
<%List<Annuncio> annunci = GestioneAnnuncio.findAll(); %>
<h1 class="table-title">ANNUNCI</h1>
<div class="table-container">
<table class="table-info">

		<thead>
			<tr>
				<th>VENDITORE ID</th>
				<th>MQ</th>
				<th>PREZZO</th>
				<th>VISITA GUIDATA</th>
				<th>VIRTUAL GUIDATA</th>			
				<%if(((Utente)session.getAttribute("logged_user")).isAmministratore() == true  ){%>
				<th>DELETE</th>
				<% } %>
				<th>VISUALIZZA</th>	
			</tr>
		</thead>

		<tbody>
			<% for (Annuncio annuncio : annunci) {	%>
			<tr>
				<td><%= annuncio.getVenditoriId() %></td>
				<td><%= annuncio.getMq() %></td>
				<td><%= annuncio.getPrezzo() %></td>
				<td><%= annuncio.isVisitaGuidata() %></td>
				<td><%= annuncio.isVirtualTour() %></td>	
				<%if(((Utente)session.getAttribute("logged_user")).isAmministratore() == true  ){%>
				<td>
					<form action = "delete" method = "get">
						<input type = "hidden" value = "<%= annuncio.getId() %>" name = "id">
						<input type = "submit" value = "elimina">
					</form>
				</td>
				
				<% } %>
				<td>
					<form action = "visualizza" method = "get">
						<input type = "hidden" value = "<%= annuncio.getId() %>" name = "idAnnuncio" />
						<input type = "hidden" value = "<%= annuncio.getIndirizzoId() %>" name = "idIndirizzo" />
						<input class="btn-visualizza" type = "submit" value = "Visualizza" />
					</form>
				</td>
						
			</tr>
			<% } %>

		</tbody>
</table>
</div>
<br>
<%if(((Utente)session.getAttribute("logged_user")).getEmail()!= null ){%>
<a href="crea_annuncio.jsp">Crea nuovo annuncio</a>
<form action = "visualizzaAnnunciSalvati" method = "get">
	<input type = "hidden" value = "<%= logged_user.getId() %>" name = "id">
	<input type = "submit" value = "Annunci Salvati">
</form>
<% } %>

</body>
</html>