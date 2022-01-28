<%@page import="it.beije.pascal.domus.enums.TipoImmobile"%>
<%@page import="it.beije.pascal.domus.enums.TipoAnnuncio"%>
<%@page import="it.beije.pascal.domus.enums.StatoRogito"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="add_annuncio" method="post">
<fieldset>
<legend>annuncio</legend>
<fieldset>
<legend>indirizzo</legend>
<label>indirizzo</label>
<input name="indirizzo">
<label>n<sup>o</sup></label>
<input name="numero">
<br>
<label>comune</label>
<input name="comune">
<label>CAP</label>
<input name="cap">
</fieldset>
<br>
<label>tipologia di immobile</label><br>
<select name="tipologia_immobile">
	<%for(TipoImmobile t: TipoImmobile.values()) { %>
	<option value="<%=t.toString()%>"><%=t.toString().toLowerCase()%></option>
	<%} %>
</select><br>
<label>tipologia di annuncio</label><br>
<select name="tipologia_annuncio">
	<%for(TipoAnnuncio t: TipoAnnuncio.values()) { %>
	<option value="<%=t.toString()%>"><%=t.toString().toLowerCase()%></option>
	<%} %>
</select><br>
<label>prezzo</label><br>
<input name="prezzo" type="number">
<br>
<label>area (mq)</label><br>
<input type="number" name="mq">
<br>
<label>stato al rogito</label><br>
<select name="stato_rogito">
	<%for(StatoRogito t: StatoRogito.values()) { %>
	<option value="<%=t.toString()%>"><%=t.toString().toLowerCase()%></option>
	<%} %>
</select>
<input name="visita_guidata" type="checkbox">
<label>visita guidata disponibile</label>
<br>
<input name="virtual_tour" type="checkbox">
<label>virtual tour disponibile</label>
</fieldset>
<input type="submit">
</form>

</body>
</html>