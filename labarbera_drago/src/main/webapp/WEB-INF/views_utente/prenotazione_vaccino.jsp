<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#campi").hide();
  		$("#prenota").click(function(){
  			$("#bottone").hide();
  			$("#campi").show();
  			
  		})
  	})
  </script>
<title>Prenotazione vaccino</title>
</head>
<body>
	<div class="jumbotron text-center">
 	<h1> Hai più di 12 anni di età?</h1>
 	<h1> Prenota il tuo Vaccino </h1>
 	</div>
 	 <div class="row">
  		<div class="col-sm-4"></div>
  		<div class="col-sm-4">
  		<div id="bottone" class="text-center">
  		<button id="prenota" class="btn btn-primary btn-lg">
   		<span class="spinner-grow spinner-grow-lg" ></span>
    			PRENOTA
  		</button>
  		</div>
  		</div>
  		<div class="col-sm-4"></div>
	</div> 
 	<div id="campi" class="container">
  		<h2>Sezione 1: <b><i>ANAGRAFICA</i></b></h2>
  		<form action="/labarbera_drago/prenotazione_vaccino" method="post" class="was-validated">
    		<div class="form-group">
     		 <label for="text">Codice fiscale:</label>
      			<input type="text" class="form-control" id="cod_fiscale" placeholder="ESEMPIO: DRGSVT99A05G273Z" name="cod_fiscale" pattern="^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$" required>
      			<div class="valid-feedback">Valido</div>
      			<div class="invalid-feedback">Immettere un campo valido</div>
    		</div>
    		<div class="form-group">
      		 <label for="text">Ultime 8 cifre Tessera sanitaria:</label>
     			 <input type="text" class="form-control" id="num_tessera" placeholder=" ESEMPIO: 80342712" name="num_tessera"  pattern="[0-9]{8}" required>
     			 <div class="valid-feedback">Valido</div>
      			 <div class="invalid-feedback">Immettere un campo valido</div>
    		</div>
    		<div class="form-group">
     		 <label for="text">Nome:</label>
      			<input type="text" class="form-control" id="nome" placeholder="ESEMPIO: Salvatore" name="nome"  required>
      			<div class="valid-feedback">Valido</div>
				<div class="invalid-feedback">Immetere un campo valido</div>
			</div>
    		<div class="form-group">
     		 <label for="text">Cognome:</label>
      			<input type="text" class="form-control" id="cognome" placeholder="ESEMPIO: Drago" name="cognome"  required>
      			<div class="valid-feedback">Valido</div>
      			<div class="invalid-feedback">Immettere un campo valido</div>
    		</div>
    		<label for="text">Sesso:</label>
    		<div class="form-check-inline">
      		 <label class="form-check-label" for="radio1">
        		<input type="radio" class="form-check-input" id="sesso" name="sesso" value="Maschio" checked>Maschio
      		 </label>
    		</div>
    		<div class="form-check-inline">
      		 <label class="form-check-label" for="radio2">
        		<input type="radio" class="form-check-input" id="sesso" name="sesso" value="Femmina">Femmina
      		 </label>
    		</div>
    		<div class="form-group">
     		 <label for="text">Data di nascita:</label>
      			<input type="Date" class="form-control" id="data_nascita"  name="data_nascita"  required>
      			<div class="valid-feedback">Valido</div>
      			<div class="invalid-feedback">Immettere un campo valido</div>
    		</div>
    		<div class="form-group">
     		 <label for="text">Cittadinanza:</label>
      			<input type="text" class="form-control" id="cittadinanza"  name="cittadinanza" placeholder="ESEMPIO: Italiana"  required>
      			<div class="valid-feedback">Valido</div>
      			<div class="invalid-feedback">Immettere un campo valido</div>
    		</div>
    		<div class="form-group">
     		 <label for="text">Residenza:</label>
      			<input type="text" class="form-control" id="residenza"  name="residenza" placeholder="ESEMPIO: Via Andrea Raia 4" required>
      			<div class="valid-feedback">Valido</div>
      			<div class="invalid-feedback">Immettere un campo valido</div>
    		</div>
    		<div class="form-group">
     		 <label for="text">Email:</label>
      			<input type="email" class="form-control" id="email"  name="email" placeholder="ESEMPIO: salvatoredrago99@gmail.com" required>
      			<div class="valid-feedback">Valido</div>
      			<div class="invalid-feedback">Immettere un campo valido</div>
    		</div>
    		<div class="form-group">
     		 <label for="text">Telefono:</label>
      			<input type="text" class="form-control" id="telefono"  name="telefono" placeholder="ESEMPIO: +39 0917371281">
      			<div class="valid-feedback">Valido</div>
      			<div class="invalid-feedback">Immettere un campo valido</div>
    		</div>
    		<div class="form-group">
     		 <label for="text">Cellulare:</label>
      			<input type="text" class="form-control" id="cellulare"  name="cellulare" placeholder="ESEMPIO: +39 3779510125">
      			<div class="valid-feedback">Valido</div>
      			<div class="invalid-feedback">Immettere un campo valido</div>
    		</div>
    
    		<button id="prosegui" type="submit" class="btn btn-primary">PROSEGUI</button>
  		</form>
</div>
 	

</body> 
</html>