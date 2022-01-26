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

	<form action="login" method="post">
	  <label for="username">username:</label><br>
	  <input type="text" name="user_name"><br>
	  <label for="password">password:</label><br>
	  <input type="text" name="pass_word"><br><br>
	  <input type="submit" value="Submit">
	</form> 

</body>
</html>