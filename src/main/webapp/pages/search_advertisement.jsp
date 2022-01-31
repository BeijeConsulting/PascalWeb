<%@page import="it.beije.pascal.bean.enums.TipoImmobile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Fai la tua ricerca</h3>

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
<form action="../searchAdvertisement" method="post">
	  
	  <label for="citta">Città:</label><br>
	  <input type="text" name="citta"><br><br>
	  
	  <label for="tipoImmobile">Tipo immobile:</label><br>
	  <select name="tipoImmobile">
	  <% for(TipoImmobile ti : TipoImmobile.values()){
		  %>
		  <option value="<%= ti %>"><%= ti %></option>
	  <% 
	  }
	  %>
	  </select>
	  
	  <br><br>
	  
	  <input type="submit" value="Submit">
	</form>

</body>
</html>