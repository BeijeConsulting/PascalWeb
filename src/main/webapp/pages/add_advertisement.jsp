<%@page import="it.beije.pascal.bean.enums.StatoRogito"%>
<%@page import="it.beije.pascal.bean.enums.Arredamento"%>
<%@page import="it.beije.pascal.bean.enums.AriaCondizionata"%>
<%@page import="it.beije.pascal.bean.enums.Riscaldamento"%>
<%@page import="it.beije.pascal.bean.enums.ClasseEnergetica"%>
<%@page import="it.beije.pascal.bean.enums.Condizione"%>
<%@page import="it.beije.pascal.bean.enums.Giardino"%>
<%@page import="it.beije.pascal.bean.enums.TipoAnnuncio"%>
<%@page import="it.beije.pascal.bean.enums.TipoImmobile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creazione annuncio</title>
</head>
<body>

<div>

<h1>Aggiunta di un nuovo annuncio</h1>

<div style="border:1px solid black; padding:10px; width:500px;">
<form action="..\addAdvertisement" method="post">

	  <label for="tipoImmobile">Tipo immobile:</label><br>
	  <select name="tipoImmobile">
	  <% for(TipoImmobile ti : TipoImmobile.values()){
		  %>
		  <option value="ti"><%= ti %></option>
	  <% 
	  }
	  %>
	  </select>
	  
	  <br><br>
	  
	  <label for="tipoAnnuncio">Tipo annuncio:</label><br>
	  <select name="tipoAnnuncio">
	  <% for(TipoAnnuncio ta : TipoAnnuncio.values()){
		  %>
		  <option value="ta"><%= ta %></option>
	  <% 
	  }
	  %>
	  </select>
	  
	  <br><br>
	  
	  <div style="border:1px solid black; padding:10px; width:300px;">
	  <h3>Indirizzo</h3>
	  <label for="comune">Comune:</label><br>
	  <input type="text" name="comune"><br><br>
	  
	  <label for="indirizzo">Via:</label><br>
	  <input type="text" name="indirizzo"><br><br>
	  
	  <label for="numeroCivico">Numero civico:</label><br>
	  <input type="text" name="numeroCivico"><br><br>
	  
	  <label for="cap">CAP:</label><br>
	  <input type="text" name="cap"><br><br>
	  </div>
	  
	  <br>
	  
	  <label for="prezzo">Prezzo:</label><br>
	  <input type="text" name="prezzo"><br><br>
	  
	  <label for="mq">Metri quadrati:</label><br>
	  <input type="text" name="mq"><br><br>
	  
	  <label for="locali">Locali:</label><br>
	  <input type="text" name="locali"><br><br>
	  
	  <label for="bagni">Bagni:</label><br>
	  <input type="text" name="bagni"><br><br>
	  
	  <label for="tot_piani">Numero di piani:</label><br>
	  <input type="text" name="tot_piani"><br><br>
	  
	  <label for="piano">Piano:</label><br>
	  <input type="text" name="piano"><br><br>
	  
	  <label for="ascensore">Ascensore:</label>
	  <input type="checkbox" name="ascensore"><br><br>
	  
	  <label for="postiAuto">Posti auto:</label><br>
	  <input type="text" name="postiAuto"><br><br>
	  
	  <label for="balcone">Balcone:</label>
	  <input type="checkbox" name="balcone"><br><br>
	  
	  <label for="terrazzo">Terrazzo:</label>
	  <input type="checkbox" name="terrazzo"><br><br>
	  
	  <label for="giardino">Giardino:</label><br>
	  <select name="giardino">
	  <% for(Giardino g : Giardino.values()){
		  %>
		  <option value="g"><%= g %></option>
	  <% 
	  }
	  %>
	  </select>
	  
	  <br><br>
	  
	  <label for="condizione">Condizione:</label><br>
	  <select name="condizione">
	  <% for(Condizione c : Condizione.values()){
		  %>
		  <option value="c"><%= c %></option>
	  <% 
	  }
	  %>
	  </select>
	  
	  <br><br>
	  
	  <label for="classeEnergetica">Classe energetica:</label><br>
	  <select name="classeEnergetica">
	  <% for(ClasseEnergetica ce : ClasseEnergetica.values()){
		  %>
		  <option value="ce"><%= ce %></option>
	  <% 
	  }
	  %>
	  </select>
	  
	  <br><br>
	  
	  <label for="riscaldamento">Tipo di riscaldamento:</label><br>
	  <select name="riscaldamento">
	  <% for(Riscaldamento r : Riscaldamento.values()){
		  %>
		  <option value="r"><%= r %></option>
	  <% 
	  }
	  %>
	  </select>
	  
	  <br><br>
	  
	  <label for="ariaCondizionata">Disponibilità aria condizionata:</label><br>
	  <select name="ariaCondizionata">
	  <% for(AriaCondizionata r : AriaCondizionata.values()){
		  %>
		  <option value="r"><%= r %></option>
	  <% 
	  }
	  %>
	  </select>
	  
	  <br><br>
	  
	  <label for="arredamento">Tipologia di arredamento:</label><br>
	  <select name="arredamento">
	  <% for(Arredamento r : Arredamento.values()){
		  %>
		  <option value="r"><%= r %></option>
	  <% 
	  }
	  %>
	  </select>
	  
	  <br><br>
	  
	  <label for="piscina">Disponibilità piscina:</label>
	  <input type="checkbox" name="piscina"><br><br>
	  
	  <label for="portineria">Presenza portineria:</label>
	  <input type="checkbox" name="portineria"><br><br>
	  
	  <label for="annoCostruzione">Anno di costruzione:</label><br>
	  <input type="text" name="annoCostruzione"><br><br>
	  
	  <label for="statoRogito">Stato del rogito:</label><br>
	  <select name="statoRogito">
	  <% for(StatoRogito r : StatoRogito.values()){
		  %>
		  <option value="r"><%= r %></option>
	  <% 
	  }
	  %>
	  </select>
	  
	  <br><br>
	  
	  <label for="visitaGuidata">Disponibilità di visita guidata:</label>
	  <input type="checkbox" name="visitaGuidata"><br><br>
	  
	  <label for="descrizioneLunga">Descrizione dell'immobile:</label><br>
	  <textarea id="descrizioneLunga" name="descrizioneLunga" rows="10" cols="50">Inserire qui la descrizione completa dell'immobile...
 	  </textarea><br><br>
 	  
 	  <label for="virtualTour">Disponibilità di visita virtuale:</label>
	  <input type="checkbox" name="virtualTour"><br><br>
	  
	  <input type="submit" value="Submit">
	  
</form>
</div>
</div>

</body>
</html>