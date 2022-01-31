<%@page import="it.beije.pascal.domus.Annuncio"%>
<%@page import="it.beije.pascal.domus.GestioneAnnuncio"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="it.beije.pascal.domus.Utente"%>
<%@page import="it.beije.pascal.domus.enums.TipoImmobile"%>
<%@page import="it.beije.pascal.domus.enums.TipoAnnuncio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

body {
	font-family: 'Arial';
	background-color: pink;
}

table {

}
tbody:nth-child(odd) {
  background-color: #ff33cc;
}

tbody:nth-child(even) {
  background-color: #e495e4;
}

tbody tr {
}

table {
  background-color: #ff33cc;
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
<br>


<%}else {%>
<a href="domus_login.html">Login</a>  
<a href="domus_registration.jsp">Registrazione</a>

<%} %>

<br><br>
<form action = "ricerca" method = "get">
	<label for = "tipoImmobile">Cerco</label>
		<select name = "tipoImmobile" onchange="javascript:handleSelect(this)">			
			<option value ="<%=TipoImmobile.CASA%>">Casa</option>		
			<option value ="<%=TipoImmobile.NUOVA_COSTRUZIONE%>">Nuova costruzione</option>
			<option value ="<%=TipoImmobile.COMMERCIALE%>">Immobile o attività commerciale</option>				
			<option value ="<%=TipoImmobile.TERRENO%>">Terreno</option>	
			<option value ="<%=TipoImmobile.GARAGE%>">Garage o posto auto</option>				
		</select>
		
	<label for = "tipoAnnuncio">In</label>
		<select name = "tipoAnnuncio">
			<option value ="<%=TipoAnnuncio.VENDITA%>">Vendita</option>		
			<option value ="<%=TipoAnnuncio.AFFITTO%>">Affitto</option>	
			<option value ="<%=TipoAnnuncio.AFFITTO_BREVE%>">Affitto breve</option>			
		</select>
		
	<label for = "comune">a</label>
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
	<input type = "submit" value = "cerca">
</form>
<%List<Annuncio> annunci = GestioneAnnuncio.findAll(); %>
<h1>Annunci</h1>
<table border = 1 align = "center" >

		<thead>
			<tr>
				<th>Venditore id</th>
				<th>Mq</th>
				<th>Prezzo</th>
				<th>Visita guidata</th>
				<th>Virtual tour</th>			
				<%if(((Utente)session.getAttribute("logged_user")).isAmministratore() == true  ){%>
				<th>Delete</th>
				<% } %>
				<th>Visualizza</th>	
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
						<input type = "hidden" value = "<%= annuncio.getId() %>" name = "idAnnuncio">
						<input type = "hidden" value = "<%= annuncio.getIndirizzoId() %>" name = "idIndirizzo">
						<input type = "submit" value = "Visualizza">
					</form>
				</td>
						
			</tr>
			<% } %>

		</tbody>
</table>
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