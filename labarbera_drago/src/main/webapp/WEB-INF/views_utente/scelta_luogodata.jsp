<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

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
  	var hub_scelto;
  	
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
  		$("#orari_disponibili").hide();
  		$("#invio").hide();
  		
  		$.get("/labarbera_drago/scelta_luogo",function(data, status){
  			obj=data;
  			var cit=estrai(obj);
  			for(var c in cit){
  					$("#sel1").append($("<option value="+cit[c]+">"+cit[c]+"</option>"));
  				}
  				
  			})
  		});
  	
  	
  	 function ricercaHub(){
  		$("#hub").empty();
  			for( var k in obj){
				if(obj[k].citta==$("select option:selected").text()){
					$("#hub").append($("<div class='col-4'><div class='card bg-primary' style='margin-top: 10px; width: 220px;height: 300px;line-height: 25px;font-size: 15px;'><div class='card-body text-center'><h3>"+obj[k].nome_hub+"</h3><br><br><h4>"+obj[k].citta+" , "+obj[k].indirizzo+"</h4><br><button  type='button' class='btn btn-light' onClick='selezionaData("+k+")'>Seleziona Hub</button></div></div></div>"));
					}
				}
	};
  	
  	function selezionaData(x){
  		hub_scelto=obj[x].cod_hub;
  		$("#scelta").hide();
  		$("#hub").hide();
  		$("#hub_scelto h2").append($("<h3 style='color:red;' id='nome_hub'>"+obj[x].nome_hub+"</h3><h4>"+obj[x].citta+", "+obj[x].indirizzo+"</h3>"));
  		$("#hub_scelto").show();
  		$("#data").show();
  		
  }
		
	function sceltaHub(){
		$("#scelta").show();
		$("#hub").show();
		$("#hub_scelto h3").remove();
		$("#hub_scelto h4").remove();
		$("#hub_scelto").hide();
		$("#data").hide();
		$("#orari_disponibili").hide();
	}
  	
	function orari(){
		if($("#data_scelta").val()!=""){
			$("#metti_data").html("<h5 style='color:red;'>"+$("#data_scelta").val()+"</h5>");
			$("#metti_orario").html("<h5></h5>");
		$.post("/labarbera_drago/scelta_ora", 
				{
					data_scelta: $("#data_scelta").val(),
					nome_hub: $("#nome_hub").text()
				},
				function(data, status){
					$("#invio").hide();
					$("#orari_disponibili").children("button").each(function(){
						$(this).removeAttr("disabled");
						$(this).removeAttr("data-toggle");
						$(this).removeAttr("title");
					});
					if(data=="1"){
						alert("Inserire una data e/o un nome hub corretto!");
						$("#orari_disponibili").hide();
					}
					else{
					
					$("#orari_disponibili").show();
					for(var i in data){
						//alert(data[i].ora);
						$("#orari_disponibili").children("button").each(function(){
							if($(this).text()==data[i].ora){
								$(this).attr("disabled","true");
								$(this).attr("data-toggle","tooltip");
								$(this).attr("title", "Orario non disponibile!");
							}
						});
					}
					}});
	
		}
		else{
			alert("Inserire una data corretta!");
		}
	}
	
	function effettuaPrenotazione(x){//fai tutto con la form e qui setti i campi del form cosi usi il dispatcher
		$("#metti_orario").html("<h5 style='color:red;'>"+x+"</h5>");
		$("#invio").children("input").each(function(){
			$(this).remove();
		});
		$("#invio").show();
		$("#invio").append($("<input name='data_scelta' type='Date' value="+$('#data_scelta').val()+" required>").hide());
		$("#invio").append($("<input name='nome_hub' type='text' value="+hub_scelto+" required>").hide());
		$("#invio").append($("<input name='ora' type='text' value="+x+" required>").hide());
		/*$.ajax({
			url: "/labarbera_drago/riepilogo",
			type: "POST",
			async: false,
			data:{
				data_scelta: $("#data_scelta").val(),
				nome_hub: $("#nome_hub").text(),
				ora: x
			},
			error: function(richiesta,stato,errori){
				$("div#risposta").html("Chiamata fallita:"+stato+""+errori);
				}
		
	});*/
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
    	<h2>HUB SELEZIONATO</h2>
    </div>
  	<br>
  	<div id="data">
  	<button class="btn btn-primary" onclick="sceltaHub()">Cambia Hub</button>
  	<br>
  	<br>
  	<h2> DATA SELEZIONATA </h2>
  	<p id="metti_data"></p>
  	<% Date data= new Date();
  	String mese;
  	if(data.getMonth()>=9){mese=""+(data.getMonth()+1)+"";}else{mese="0"+(data.getMonth()+1)+"";}
  	String data_min=""+(data.getYear()+1900)+"-"+mese+"-"+data.getDate()+"";
  	out.println("<input type='Date' id='data_scelta' class='form-control' min="+data_min+" required>");
  	%>
  	<br>
  	<button class="btn btn-primary"  onclick="orari()">Seleziona Data</button>
  	</div>
  	<br><br>
  	<div id="orari_disponibili">
  	<h2> ORARIO SELEZIONATO</h2>
  	<p id="metti_orario"></p>
  		<button type="submit"  onClick="effettuaPrenotazione('08:00-09:00')" class="btn btn-outline-primary">08:00-09:00</button>
  		<button type="submit" onClick="effettuaPrenotazione('09:00-10:00')" class="btn btn-outline-primary">09:00-10:00</button>
  		<button type="submit" onClick="effettuaPrenotazione('10:00-11:00')" class="btn btn-outline-primary">10:00-11:00</button>
  		<button type="submit" onClick="effettuaPrenotazione('11:00-12:00')" class="btn btn-outline-primary">11:00-12:00</button>
  		<button type="submit" onClick="effettuaPrenotazione('12:00-13:00')" class="btn btn-outline-primary">12:00-13:00</button>
  		<br><br>
  		<div class="row">
  			<div class="col">
  			</div>
  			<div class="col">
  				<form id="invio" action="/labarbera_drago/riepilogo" method="post">
  					<button type="submit" class="btn btn-primary">PRENOTA</button>
  				</form>
  			</div>
  			<div class="col">
  			</div>
  		</div>
  		
  		
  	</div>
  	
  	
  	
  </div>
  
</body>
</html>