<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<%
String error = (String)session.getAttribute("error");
if (error != null) {
	out.print(error + "<br><br>");
	session.removeAttribute("error");
}
%>

	<form action="dblogin" method="post">
	  <label for="email">Email:</label><br>
	  <input type="email" name="email"><br>
	  <label for="password">Password:</label><br>
	  <input type="text" name="password"><br><br>
	  <input type="submit" value="Submit">
	</form> 
	<form action="register.jsp" method="post">
   	  <input type="submit" value="Registrati"></input>
    </form> 

</body>
</html>