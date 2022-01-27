<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="it.beije.pascal.web.tabella.bean.Contatto"%>
<%@ page import = "it.beije.pascal.web.tabella.query.Sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Contatto> contatti = Sql.findAll();
	%>
	<table>

		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Telefono</th>
				<th>Email</th>
				<th>Note</th>				
				<th>
					<form action = "insert-form.jsp"  method = "get">
						<input type = "submit" value = "Aggiungi Contatto">
					</form>
				</th>
			</tr>
		</thead>

		<tbody>
			<% for (Contatto contatto : contatti) {	%>
			<tr>
				<td><%= contatto.getNome() %></td>
				<td><%= contatto.getCognome() %></td>
				<td><%= contatto.getTelefono() %></td>
				<td><%= contatto.getEmail() %></td>
				<td><%= contatto.getNote() %></td>
				<td>
					<form action="../delete" method="get">
						<input type="hidden" value="<%= contatto.getId()%>" name="id">
						<input type="submit" value="Elimina">
					</form></td>
				<td>
					<form action="update-form.jsp" method = "get">
						<input type = "hidden" name = "id" value = "<%= contatto.getId() %>">
						<input type = "submit" value = "Modifica">
					</form>
				</td> 
			</tr>
			<% } %>

		</tbody>

	</table>
	<br>
	<br>
	<!-- <iframe name = "action" ></iframe> -->
	
	
</body>
</html>

















