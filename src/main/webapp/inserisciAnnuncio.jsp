<%@page import="it.beije.pascal.web.beans.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Annuncio</title>
</head>
<body>

<h1>Domus</h1>
<h2>Qua puoi inserire un nuovo annuncio</h2>
<% 
Utente u = (Utente)session.getAttribute("loggedUser");
%>
<span style="color:green"><%= u.getEmail() %></span><br><br>

<form action="aggiungiAnnuncio" method="post">
<label>Indirizzo:</label><br><br>
<label>Comune</label>
<input type="text" name="comune"><br>
<label>Indirizzo</label>
<input type="text" name="indirizzo"><br>
<label>Numero civico</label>
<input type="number" name="civico"><br>
<label>CAP</label>
<input type="text" name="cap"><br><br>

<br><br>

<label>Tipo di immobile</label>
<select name="tipoImmobile">
<option value="casa">Casa</option>
<option value="nuovaCostruzione">Nuova costruzione</option>
<option value="commerciale">Commericale</option>
<option value="terreno">Terreno</option>
<option value="garage">Garage</option>
<option value="stanza">Stanza</option>
<option value="postoLetto">Posto Letto</option>
<option value="cantinaSolaio">Cantina/Solaio</option>
<option value="postoBarca">Posto barca</option>
</select>

<br><br>

<label>Tipo di annuncio:</label>
<select name="tipoAnnuncio">
<option value="vendita">Vendita</option>
<option value="affitto">Affitto</option>
<option value="affittoBreve">Affitto breve</option>
</select>

<br><br>

<label>Prezzo:</label>
<input type="text" name="prezzo"><br>

<label>Metri quadrati:</label>
<input type="number" name="metriQuadri"><br>

<label>Numero di locali:</label>
<input type="number" name="locali"><br>

<label>Numero di bagni:</label>
<input type="number" name="bagni"><br>

<label>Numero di piani:</label>
<input type="number" name="piani"><br>

<label>Ascensore:</label>
<input type="checkbox" name="ascensore"><br>

<label>Numero di posti auto:</label>
<input type="number" name="postiAuto"><br>

<label>Balcone:</label>
<input type="checkbox" name="balcone"><br>

<label>Terrazza:</label>
<input type="checkbox" name="terrazza"><br>

<label>Piscina:</label>
<input type="checkbox" name="piscina"><br>

<label>Portineria:</label>
<input type="checkbox" name="portineria"><br>

<label>Visita guidata:</label>
<input type="checkbox" name="visitaGuidata"><br>

<label>Virtual tour:</label>
<input type="checkbox" name="virtualTour"><br>

<label>Giardino:</label>
<select>
<option value="no">No</option>
<option value="comune">Comune</option>
<option value="privato">Privato</option>
</select><br>

<label>Condizione:</label>
<select>
<option value="nuovo">Nuovo</option>
<option value="buono">Buono</option>
<option value="daRistrutturare">Da ristrutturare</option>
</select><br>

<label>Stato rogito:</label>
<select>
<option value="occupato">Occupato</option>
<option value="libero">Libero</option>
<option value="nudaProprietà">Nuda proprietà</option>
<option value="affittato">Affittato</option>
</select><br><br>

<br>
<input type="submit" value="Submit">

</form>


</body>
</html>