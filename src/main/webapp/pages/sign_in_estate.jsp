<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign in Estate</title>
</head>
<body>

<h1>Pagina di Registrazione Agenzia</h1>

<form action="..\registerEstate" method="post">

	  <label for="ragioneSociale">Ragione sociale:</label><br>
	  <input type="text" name="ragioneSociale"><br><br>
	  
	  <label for="cognomeReferente">Cognome referente:</label><br>
	  <input type="text" name="cognomeReferente"><br><br>
	  
	  <label for="nomeReferente">Nome referente:</label><br>
	  <input type="text" name="nomeReferente"><br><br>
	  
	  <label for="telefono">Telefono:</label><br>
	  <input type="text" name="telefono"><br><br>
	  
	  <label for="partitaIva">Partita iva:</label><br>
	  <input type="text" name="partitaIva"><br><br>
	  
	  <h3>Indirizzo</h3>
	  
	  <label for="comune">Comune:</label><br>
	  <input type="text" name="comune"><br>
	  
	  <label for="via">Via:</label><br>
	  <input type="text" name="via"><br>
	  
	  <label for="cap">CAP:</label><br>
	  <input type="text" name="cap"><br>
	  
	  <label for="civico">Numero civico:</label><br>
	  <input type="text" name="civico"><br><br>
	  
	  <input type="submit" value="Registra">
	  
</form>

</body>
</html>