<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Domus</title>

<style>
	body {
		font-family: Arial;
	}
	div {
		max-width: 450px;
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
</style>

</head>
<body>
<div>
<form action="register_user" method="post">

<h1>Registrazione</h1>
	<label>email:	</label>
	<input type="email" name="email">
	<br />
	<label>password:</label>
	<input type="password" name="password">
	<br />
	<label>Acconsento al trattamento dei dati: </label>
	<br />
		<input type="checkbox" name="spam_check">
	<br />
	<input class="btn" type="submit" value="Registrati">

</form>
</div>

</body>
</html>