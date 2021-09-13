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
  	var obj;
  	function setObj(x){
  		obj= JSON.parse(x);
  	}
  	$(document).ready(function(){
  		$("#data").hide();
  		$.get("/labarbera_drago/scelta_luogo",function(data, status){
  			var json = JSON.stringify(data);
  			setObj(json);
  			var citta=null;
  			for(var o in obj){
  				if(citta!=obj[o].citta){
  					$("#sel1").append($("<option value="+obj[o].citta+">"+obj[o].citta+"</option>"));
  				}
  				citta=obj[o].citta;
  			}
  		});
  		
  	});
  	
  	
  	 function ricercaHub(){
  		$("#hub").empty();
  		for(var o in obj){
			if(obj[o].citta==$("select option:selected").text()){
				$("#hub").append($("<div class='card bg-primary'><div class='card-body text-center'><p class='card-text'><h3>"+obj[o].nome_hub+"</h3><br><br><h4>"+obj[o].citta+" , "+obj[o].indirizzo+"</h4><br></p><button type='button' class='btn btn-light' onClick='selezionaData()''>Seleziona Hub</button></div></div>"));
			}
		}
  	};
  	
  	function selezionaData(){
  		$("#data").show();
  	}
		

  	
  </script>
<title>SCELTA LUOGO e DATA</title>
</head>
<body>
	<div id="scelta" class="container">
  		<h2>Sezione 2: <b><i>LUOGO, DATA e ORA</i></b></h2>
    	<div class="form-group">
    	
      		<label for="sel1">Seleziona la Citt�:</label>
      		<select class="form-control" id="sel1" name="sellist1" onClick="ricercaHub()">
      		</select>
      	</div>		
      <br>
    <div id="hub" class="card-deck">
  	</div>
  	<br>
  	<br>
  	<div id="data">
  	<p> Seleziona la Data: </p>
  	<input type="Date" class="form-control" id="data_nascita"  name="data_nascita"  required>
  	</div>
    
</body>
</html>