<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal page</title>
<h> PAGINA PERSONALE DELL'UTENTE </h>
</head>
<body>

<jsp:useBean id="loggedUser" class="it.beije.domus.Utente" scope="session"></jsp:useBean>

<jsp:setProperty property="username" name="loggedUser" param="user_name"/>
<jsp:setProperty property="password" name="loggedUser" param="pass_word"/>

USERNAME = <jsp:getProperty property="username" name="loggedUser"/>
PASSWORD = <jsp:getProperty property="password" name="loggedUser"/>

</body>
</html>