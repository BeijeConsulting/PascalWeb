<%@page import="it.beije.pascal.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="it.beije.pascal.rubrica.JPAmanager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">Tutti gli utenti</h3>
	<div align="center">
		<table border="2" width="1" cellspacing="1" cellpadding="2">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
					<th>email</th>
					<th>telefono</th>
					<th>note</th>
				</tr>
			</thead>

			<tbody>
				<%
				List<Contatto> contatti = JPAmanager.allContatti();
				for (Contatto contatto : contatti) {
				%>
				<tr>
					<td><%=contatto.getNome()%></td>
					<td><%=contatto.getCognome()%></td>
					<td><%=contatto.getEmail()%></td>
					<td><%=contatto.getTelefono()%></td>
					<td><%=contatto.getNote()%></td>
					<td>
						<form action="csv_servletJSP" method="post">
							<input type="hidden" value="<%=contatto.getId()%>" name="id">
							<input type="Submit" value="delete" name="delete">
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<br>
	</div>

	<hr>
	<form action="csv_servletJSP" method="post" align="center">
		<h1>Cerca contatti</h1>
		<label>Category:</label> <select name="category" id="category">
			<option value="nome">Nome</option>
			<option value="cognome">Cognome</option>
			<option value="telefono">telefono</option>
			<option value="email">email</option>
			<option value="note">note</option>
		</select> <br> <label>value:</label><br> <input type="text"
			name="value"> <br> <br> <input type="Submit"
			value="Find" name="select">
	</form>
	<%
	try {
		contatti = (List<Contatto>) session.getAttribute("contatti");
	} catch (Exception ex) {
		System.out.print(ex.getMessage());
	}
	out.print(contatti);
	%>


	<hr>
	<h3 align="center">Nuovo Utente</h3>
	<form action="csv_servletJSP" method="post" align="center">
		<label>congome:</label><br> <input type="text" name="cognome"><br>
		<label>nome:</label><br> <input type="text" name="nome"><br>
		<label>telefono:</label><br> <input type="text" name="telefono"><br>
		<label>email:</label><br> <input type="text" name="email"><br>
		<label>note:</label><br> <input type="text" name="note"><br>
		<br> <input type="submit" value="Insert" name="insert">
	</form>



</body>
</html>