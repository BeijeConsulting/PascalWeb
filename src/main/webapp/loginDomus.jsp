<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Domus login</title>
</head>
<body>

<h1>Domus</h1>

<% 
String error = (String)session.getAttribute("error");
if(error!=null){
	out.print(error + "<br><br>");
	session.removeAttribute("error");
}
%>

<form action="controlloLogin" method="post">
<label>Email</label>
<input type="text" name="email"><br><br>
<label>Password</label>
<input type="text" name="password"><br><br>
<input type="submit" value="Login">
</form>

</body>
</html>