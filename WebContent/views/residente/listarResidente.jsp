<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista residentes</title>
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
		<h1>Lista de residentes registrados</h1>
	</section>

	<table border= "1">
		<tr>
			<td>ID residente</td>
			<td>Nombre</td>			
			<td>Apellido</td>
			<td>Identificación</td>
			<td>Fecha nacimiento</td>
			<td>Telefono</td>
			<td>Correo electronico</td>
			<td>Estado residente</td>
			<td>Número apartamento</td>
			<td>Número torre</td>
			<td>Categoria</td>			
			<td>Accion1</td>
			<td>Accion2</td>
		</tr>

		<c:forEach var="residente" items="${lista}">
		<tr>
			
			<td><c:out value="${residente.idResidente}"></c:out></td>			
			<td><c:out value="${residente.nombre}"></c:out></td>
			<td><c:out value="${residente.apellido}"></c:out></td>
			<td><c:out value="${residente.identificacion}"></c:out></td>
			<td><c:out value="${residente.fechaNacimiento}"></c:out></td>
			<td><c:out value="${residente.telefono}"></c:out></td>
			<td><c:out value="${residente.email}"></c:out></td>
			<td><c:out value="${residente.estado}"></c:out></td>
			<td><c:out value="${residente.apartamento}"></c:out></td>
			<td><c:out value="${residente.torre}"></c:out></td>
			<td><c:out value="${residente.categoria}"></c:out></td>
						
			<td><a href="http://localhost:8080/CRUD-usuario/ResidenteController?opcion=eliminar&idResidente=<c:out value="${residente.idResidente}"></c:out>">Eliminar</a></td>
			<td><a href="http://localhost:8080/CRUD-usuario/ResidenteController?opcion=editar&idResidente=<c:out value="${residente.idResidente}"></c:out>">Editar</a></td>
		</tr>
		</c:forEach>

	</table>
</body>
</html>



