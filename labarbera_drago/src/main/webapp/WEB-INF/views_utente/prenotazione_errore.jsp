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
<title>Prenotazione Errore</title>
</head>
<body>
	<div>
		<h1>ERRORE PRENOTAZIONE!</h1>
		
	</div>
	<div>
	<% 
		out.println("<h3>" + request.getAttribute("errore") + "</h3>");
	%>
	</div>
	<div>
	<a href="/labarbera_drago/prenotazione_vaccino.jsp"><button  class="btn btn-primary">Torna alla pagina di prenotazione</button></a>
	</div>
</body>
</html>