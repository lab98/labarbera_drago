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
  <!--  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#campi").hide();
  		$("#login").click(function(){
  			$("#bottone").hide();
  			$("#campi").show();
  			
  		})
  	})
  </script>-->
<title>login page </title>
</head>
<body>
	
 	<div id="campi" class="container">
  		
  		<form action="/labarbera_drago/login" method="post" class="was-validated">
    		<div class="form-group">
     		 <label for="text">Codice Operatore:</label>
      			<input type="text" class="form-control" id="cod_operatore" placeholder="ESEMPIO: 1|12|123..." name=cod_operatore pattern="[0-9]+" required>
      			<div class="valid-feedback">Valido</div>
      			<div class="invalid-feedback">Immettere un campo valido</div>
    		</div>
    		<div class="form-group">
      		 <label for="text">Password :</label>
     			 <input type="password" class="form-control" id="password"  name="password" required>
     			 <div class="valid-feedback">Valido</div>
      			 <div class="invalid-feedback">Immettere un campo valido</div>
    		</div>
    
    		<button id="login" type="submit" class="btn btn-primary">LOGIN</button>
  		</form>
</div>
 	

</body> 
</html>