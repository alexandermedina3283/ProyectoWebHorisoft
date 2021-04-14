<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista apartamentos</title>
<style>
body{
background-color: #f2f2f2;
font-family: Arial;
}
table {
	width: 100%;
	background-color: white;
	border-collapse: collapse;	
}
td,th{
padding: 7px;
}
tr:nth-child(even){
background-color: #ddd;
}


</style>
</head>
<body>
	
	
	<section class="logo">
		<img src="img/Cabecero.png" alt="">
		<h1>Lista de apartamentos registrados</h1>
	</section>

	<table border= "1">
		<tr>
			<td>Numero apartamento</td>
			<td>Numero torre</td>			
			<td>Estado cartera</td>
			<td>Accion1</td>
			<td>Accion2</td>
		</tr>

		<c:forEach var="apartamento" items="${lista}">
		<tr>
			
			<td><c:out value="${apartamento.apartamento}"></c:out></td>
			<td><c:out value="${apartamento.torre}"></c:out></td>			
			<td><c:out value="${apartamento.estadoCartera}"></c:out></td>			
			<td><a href="http://localhost:8080/CRUD-usuario/ApartamentoController?opcion=eliminar&apartamento=<c:out value="${apartamento.apartamento}"></c:out>&torre=<c:out value="${apartamento.torre}"></c:out>">Eliminar</a></td>
			<td><a href="http://localhost:8080/CRUD-usuario/ApartamentoController?opcion=editar&apartamento=<c:out value="${apartamento.apartamento}"></c:out>&torre=<c:out value="${apartamento.torre}"></c:out>">Editar</a></td>
		</tr>
		</c:forEach>

	</table>
</body>
</html>




















