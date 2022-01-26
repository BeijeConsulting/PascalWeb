<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rubrica</title>
</head>
<body>
	<iframe name="result" width="1024"></iframe>
	<form action="add_contatto" method="post" target="result">
		<fieldset>
			<legend>Inserisci: </legend>
			<label>Nome: </label> <br> <input name="name" type="text">
			<br> <label>Cognome: </label> <br> <input name="lastname"
				type="text"> <br> <label>Telefono</label> <br> <input
				name="phone" type="tel"> <br> <label>Nome</label> <br>
			<input name="email" type="email"> <br> <label>Email
			</label> <br> <input name="note" type="text"> <br> 
			<input type="submit" value="Submit">
		</fieldset>
	</form>
	
	<form action="list_contatti" method="get" target="result">
		<fieldset>
			<legend>Lista i contatti</legend>
			<label>Ordina per</label><br>
			<input type="radio" name="order_column" value="nome" checked>
			<label>nome</label>
			<input type="radio" name="order_column" value="cognome">
			<label>cognome</label><br>
			<input type="radio" name="order_direction" value="ascendente" checked>
			<label>ascendente</label>
			<input type="radio" name="order_direction" value="discendente">
			<label>discendente</label>
			<br> <input type="submit" value="Visualizza">
		</fieldset>
	</form>

	<fieldset>
		<legend>Importa</legend>
		<form action="import_file" target="result" method="post">
			<label>file sul server: </label>
			<input name="nome_file">
			<input type="submit" value="Visualizza"><br>
		</form>
		
	</fieldset>
	
	<fieldset name="cerca">
		<legend>Cerca</legend>
		<form action="cerca_nome" method="post" target="result">
		<label>Nome: </label>
		<input type="text" name="nome"><br>
		<label>Cognome: </label>
		<input type="text" name="cognome"><br>
		<input type="submit" value="Cerca">
		</form>
	</fieldset>
	
	<fieldset name="modifica">
		<legend>Modifica </legend>
		<form action="modifica" method="post" target="da_modificare">
			<label>Id:</label>
			<input type="number" name="id">
			<input type="submit" value="Cerca" name="visualizza">
		</form>
		<iframe name="da_modificare" ></iframe>
	</fieldset>
	
</body>
</html>