<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista mascotas</title>
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
		<h1>Lista de mascotas registradas</h1>
	</section>

	<table border= "1">
		<tr>
			<td>Numero mascota</td>
			<td>Nombre</td>			
			<td>Clase</td>
			<td>Apartamento</td>
			<td>Torre</td>
			<td>Accion1</td>
			<td>Accion2</td>
		</tr>

		<c:forEach var="mascota" items="${lista}">
		<tr>
			
			<td><c:out value="${mascota.idMascota}"></c:out></td>
			<td><c:out value="${mascota.nombre}"></c:out></td>			
			<td><c:out value="${mascota.clase}"></c:out></td>	
			<td><c:out value="${mascota.apartamento}"></c:out></td>	
			<td><c:out value="${mascota.torre}"></c:out></td>			
			<td><a href="http://localhost:8080/CRUD-usuario/MascotaController?opcion=eliminar&idMascota=<c:out value="${mascota.idMascota}"></c:out>">Eliminar</a></td>
			<td><a href="http://localhost:8080/CRUD-usuario/MascotaController?opcion=editar&idMascota=<c:out value="${mascota.idMascota}"></c:out>">Editar</a></td>
		</tr>
		</c:forEach>

	</table>
</body>
</html>




















