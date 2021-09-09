<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recupera Credenziali</title>
</head>
<body>
<div id="campi" class="container">
  		
  		<form action="/labarbera_drago/RecuperaCredenziali" method="post" class="was-validated">
    		<div class="form-group">
     		 <label for="text">Inserisci codice Fiscale </label>
      			<input type="text" class="form-control" id="cod_fiscale"  name=cod_fiscale required>
      			 <div class="invalid-feedback">Immettere un campo valido</div>
    		</div>
    		<button id="Conferma" type="submit" class="btn btn-primary">Conferma</button>
  		</form>
</div>

</body>
</html>