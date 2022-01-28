<%@page import="javax.swing.JOptionPane"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Pagina di Login Utente</h1>
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

	<form action="../loginUser" method="post">
	  <label for="email">email:</label><br>
	  <input type="text" name="email"><br>
	  <label for="password">password:</label><br>
	  <input type="text" name="pass_word"><br><br>
	  <input type="submit" value="Submit">
	</form>
</body>
</html>