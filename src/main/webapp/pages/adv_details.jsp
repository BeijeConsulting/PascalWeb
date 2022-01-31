<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Dettagli annuncio</h1>

<div>
<jsp:useBean id="adv" class="it.beije.pascal.bean.Annuncio" scope="session"></jsp:useBean>
TIPO IMMOBILE = <jsp:getProperty property="tipoImmobile" name="adv"/><br>
PREZZO = <jsp:getProperty property="prezzo" name="adv"/><br>
METRI QUADRATI = <jsp:getProperty property="mq" name="adv"/><br>
ANNO DI COSTRUZIONE = <jsp:getProperty property="anno_costruzione" name="adv"/><br>
</div>

</body>
</html>
