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
  		$.get("/labarbera_drago/scelta_luogo",function(data, status){
  			var json = JSON.stringify(data);
  			for(i=0; i<json.lenght();i++){
  				citta=json.
  			}
  			
  		});
  	});
  </script>
<title>SCELTA LUOGO e DATA</title>
</head>
<body>
	<div id="scelta" class="container">
  		<h2>Sezione 2: <b><i>LUOGO, DATA e ORA</i></b></h2>
    	<div class="form-group">
    	
      		<label for="sel1">Seleziona la Città:</label>
      		<select class="form-control" id="sel1" name="sellist1">
      		
      		
        		<option>1</option>
        		<option>2</option>
       		 	<option>3</option>
        		<option>4</option>
      		</select>
      <br>
     
    </div>
    

	</div>
</body>
</html>