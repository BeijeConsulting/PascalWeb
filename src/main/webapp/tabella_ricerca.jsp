<%@page import="java.util.List"%>
<%@page import="it.beije.pascal.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Telefono</th>
			<th>Email</th>
			<th>Note</th>
		</tr>
		<%
		List<Contatto> contattiList = (List<Contatto>) session.getAttribute("contatti_list");
		if(contattiList !=null){
			for(Contatto c : contattiList)
			{
		%>
		
		
		<tr>
			<td><%=c.getId() %></td>
			<td><%=c.getNome() %></td>
			<td><%=c.getCognome() %></td>
			<td><%=c.getTelefono() %></td>
			<td><%=c.getEmail() %></td>
			<td><%=c.getNote() %></td>
		</tr>
		
		
		<%}} %>
	</table>
	
</body>
</html>