<%@page import="it.beije.pascal.domus.enums.TipoImmobile"%>
<%@page import="it.beije.pascal.domus.enums.TipoAnnuncio"%>
<%@page import="it.beije.pascal.domus.enums.StatoRogito"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Domus</title>
<style>
	body {
		font-family: Arial;
		text-align: center;
	}
	div {
		max-width: 650px;
		margin: auto;
		margin-top: 100px;
		color: white;
		background-color: #11101d;
		padding: 30px;
		border-radius: 7px;
	}
	h1 {
		border-bottom: 2px solid white;
	}
	label {
		margin-right: 20px;
	}
	input {
		margin-left: 20px;
		border: none;
		margin: 10px;
		background: #29282c;
		border-radius: 5px;
		color: white;
		font-size: 15px;
		padding: 5px;
	}
	.btn {
		padding: 12px;
		font-size: 15px;
		border: 1px solid white;
		border-radius: 4px;
		cursor: pointer;
	}
	select {
  		border: none;
  		border-bottom: 2px solid black;
		padding: 10px;
		font-size: 15px;
	}
	.btn-home {
		margin: 20px;
		background-color: #11101d;
		padding: 12px;
		color: white;
		border-radius: 5px;
		font-size: 15px;
		cursor: pointer;
		border: none;
	}
	.home-link {
		color: white;
		text-decoration: none;
	}
</style>
</head>
<body>

<div>
<form action="add_annuncio" method="post">

<h1>ANNUNCIO</h1>

<label>INDIRIZZO</label>
<input name="indirizzo">
<label>N°</label>
<input name="numero">
<br />
<label>COMUNE</label>
<input name="comune">
<label>CAP</label>
<input name="cap">
<br />
<br />
<br />
<label>TIPOLOGIA DI IMMOBILE</label><br>
<select name="tipologia_immobile">
	<%for(TipoImmobile t: TipoImmobile.values()) { %>
	<option value="<%=t.toString()%>"><%=t.toString().toLowerCase()%></option>
	<%} %>
</select>
<br />
<br />
<br />
<label>TIPOLOGIA DI ANNUNCIO</label>
<br />

<select name="tipologia_annuncio">
	<%for(TipoAnnuncio t: TipoAnnuncio.values()) { %>
	<option value="<%=t.toString()%>"><%=t.toString().toLowerCase()%></option>
	<%} %>
</select>
<br />
<br />
<br />
	<label>PREZZO</label>
<br />
<input name="prezzo" type="number">
<br />
<br />
<br />
<label>AREA (MQ)</label>
<br />
<input type="number" name="mq">
<br />
<br />
<br />
<label>STATO AL ROGITO</label>
<br />
<select name="stato_rogito">
	<%for(StatoRogito t: StatoRogito.values()) { %>
	<option value="<%=t.toString()%>"><%=t.toString().toLowerCase()%></option>
	<%} %>
</select>
<br />
<br />
<br />
<input name="visita_guidata" type="checkbox">
<label>visita guidata disponibile</label>
<br />
<input name="virtual_tour" type="checkbox">
<label>virtual tour disponibile</label>

<br />
<br />
<input style="padding: 10px; font-size: 15px;" type="submit" value="CREA">
</form>
</div>

<button class="btn-home">
		<a class="home-link" href="domus_home.jsp">Home</a>  
	</button>

</body>
</html>