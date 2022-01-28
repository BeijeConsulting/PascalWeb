<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 style="color:brown">Benvenuto nella tua pagina</h1>

<div>
<jsp:useBean id="loggedUser" class="it.beije.pascal.bean.Utente" scope="session"></jsp:useBean>
<jsp:setProperty property="username" name="loggedUser" param="user_name"/>
<jsp:setProperty property="password" name="loggedUser" param="pass_word"/>
USERNAME = <jsp:getProperty property="username" name="loggedUser"/><br>
PASSWORD = <jsp:getProperty property="password" name="loggedUser"/><br>
<!--ID_COMMERCIALE = <jsp:getProperty property="commercialeId" name="loggedUser"/><br>  -------- IT SEEMS BUGGED -->
EMAIL = <jsp:getProperty property="email" name="loggedUser"/><br>
AVATAR_URL = <jsp:getProperty property="avatarUrl" name="loggedUser"/><br>
SPAM CHECK = <input type="checkbox" checked="checked"><br>
AMMINISTRATORE = <input type="checkbox"><br>
</div>

<br><br>

<div>
<form action="../addAdvertisement" method="get">
<input type="submit" value="inserisci annuncio">
</form>
</div>

<br><br>

<div>
<form action="../searchAdvertisement" method="get">
<input type="submit" value="cerca annuncio">
</form>
</div>

</body>
</html>