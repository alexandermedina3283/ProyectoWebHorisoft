<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista parqueaderos</title>
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
		<h1>Lista de parqueaderos registrados</h1>
	</section>

	<table border= "1">
		<tr>
			<td>Número parqueadero</td>
			<td>Ubicación</td>			
			<td>Placa vehículo</td>
			<td>Modelo</td>
			<td>Color</td>
			<td>Marca</td>
			<td>Apartamento</td>
			<td>Torre</td>
			<td>Clase vehiculo</td>
			<td>Accion1</td>
			<td>Accion2</td>
		</tr>

		<c:forEach var="parqueadero" items="${lista}">
		<tr>
			
			<td><c:out value="${parqueadero.idParqueadero}"></c:out></td>			
			<td><c:out value="${parqueadero.ubicacionParqueadero}"></c:out></td>
			<td><c:out value="${parqueadero.placaVehiculo}"></c:out></td>
			<td><c:out value="${parqueadero.modeloVehiculo}"></c:out></td>
			<td><c:out value="${parqueadero.colorVehiculo}"></c:out></td>
			<td><c:out value="${parqueadero.marcaVehiculo}"></c:out></td>
			<td><c:out value="${parqueadero.apartamento}"></c:out></td>
			<td><c:out value="${parqueadero.torre}"></c:out></td>
			<td><c:out value="${parqueadero.claseVehiculo}"></c:out></td>
						
			<td><a href="http://localhost:8080/CRUD-usuario/ParqueaderoController?opcion=eliminar&idParqueadero=<c:out value="${parqueadero.idParqueadero}"></c:out>">Eliminar</a></td>
			<td><a href="http://localhost:8080/CRUD-usuario/ParqueaderoController?opcion=editar&idParqueadero=<c:out value="${parqueadero.idParqueadero}"></c:out>">Editar</a></td>
		</tr>
		</c:forEach>

	</table>
</body>
</html>



