<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Page</title>
</head>
<body>
<p><% out.print(session.getAttribute("MedicoLog")); %></p>
</body>
</html>