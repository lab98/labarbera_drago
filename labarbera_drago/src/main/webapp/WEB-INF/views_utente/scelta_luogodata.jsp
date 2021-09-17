<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
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
  	var k;
  //	Date date= new SimpleDateFormat("yyyy-MM-dd");
  	
  	function setObj(x){
  		obj= JSON.parse(x);
  	}
  	function estrai(x){
  		var f=0;
  		var citta=[x[0].citta];
  		for( var o in x){
  			for(var i in citta){
  				if(x[o].citta==citta[i]){
  					f=1;
  				}
  			}
  			if(f!=1){
  			citta.push(x[o].citta);
  			}
  			f=0;
  		}
  		return citta;
  	}
  	
  	$(document).ready(function(){
  		//alert(date);
  		$("#data").hide();
  		$("#hub_scelto").hide();
  		$.get("/labarbera_drago/scelta_luogo",function(data, status){
  			var json = JSON.stringify(data);
  			setObj(json);
  			var cit=estrai(obj);
  			for(var c in cit){
  					$("#sel1").append($("<option value="+cit[c]+">"+cit[c]+"</option>"));
  				}
  				
  			})
  		});
  	
  	
  	 function ricercaHub(){
  		$("#hub").empty();
  			for( k in obj){
				if(obj[k].citta==$("select option:selected").text()){
					$("#hub").append($("<div class='col-4'><div class='card bg-primary' style='margin-top: 10px; width: 220px;height: 300px;line-height: 25px;font-size: 15px;'><div class='card-body text-center'><h3>"+obj[k].nome_hub+"</h3><br><br><h4>"+obj[k].citta+" , "+obj[k].indirizzo+"</h4><br><button  type='button' class='btn btn-light' onClick='selezionaData("+obj[k]+")'>Seleziona Hub</button></div></div></div>"));
					}
				}
	};
  	
  	function selezionaData(x){
  		$("#scelta").hide();
  		$("#hub").hide();
  		$("#hub_scelto").append($("<h3>"+x.nome_hub+", "+x.citta+", "+x.indirizzo+"</h3>")).show();
  		$("#data").show();
  		$("#data_nascita").attr("min","2021-09-17");
  }
		

  	
  </script>
<title>SCELTA LUOGO e DATA</title>
</head>
<body>
	<div class="container">
  		<h2>Sezione 2: <b><i>LUOGO, DATA e ORA</i></b></h2>
    	<div id="scelta" class="form-group">
    		<label for="sel1">Seleziona la Città:</label>
      		<select class="form-control" id="sel1" name="sellist1" onClick="ricercaHub()">
      		</select>
      	</div>	
     
      <br>
    <div id="hub" class="card-deck">
    </div>
    <div id="hub_scelto">
    	
    </div>
  	<br>
  	<br>
  	<div id="data">
  	<p> Seleziona la Data: </p>
  	<input type="Date" class="form-control" id="data_nascita"  name="data_nascita"  required>
  	</div>
  </div>
    
</body>
</html>