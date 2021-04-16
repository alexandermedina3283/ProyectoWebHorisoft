<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar parqueadero</title>
</head>
<body>

<section>
		<h1>Actualizar información del parqueadero - vehículo</h1>
		<form action="http://localhost:8080/CRUD-usuario/ParqueaderoController" method="post">
			<c:set var="parqueadero" value="${parqueadero}"></c:set>
			<input type="hidden" name="opcion" value="editar">
			<input type="hidden" name="idMascota" value="${parqueadero.idParqueadero}">
			<fieldset>

				<legend>Datos del parqueadero - vehiculo </legend>

				<label for="idParqueadero">Numero parqueadero</label> <input
					name="idParqueadero" id="idParqueadero" value="${parqueadero.idParqueadero}" type="text"
					placeholder="Escriba número parqueadero" /> <br />
					
				<label for="ubicacionParqueadero">Ubicación</label> <input
					name="ubicacionParqueadero" id="ubicacionParqueadero" value="${parqueadero.ubicacionParqueadero}" type="text"
					placeholder="Ubicación parqueadero" list="listaubicacionParqueadero"
					required/> <br />
					
				<datalist id="listaubicacionParqueadero">
					<option value="Sotano"/>
					<option value="Piso 1"/>
					<option value="Piso 2"/>
					<option value="Piso 3"/>
					<option value="Azotea"/>
				</datalist>
				
				<label for="placaVehiculo">Placa</label> <input
					name="placaVehiculo" id="placaVehiculo" value="${parqueadero.placaVehiculo}" type="text"
					placeholder="Placa vehiculo" /> <br />
				
				<label for="modeloVehiculo">Modelo</label> <input
					name="modeloVehiculo" id="modeloVehiculo" value="${parqueadero.modeloVehiculo}" type="text"
					placeholder="Modelo vehiculo" /> <br />
				
				<label for="colorVehiculo">Color</label> <input
					name="colorVehiculo" id="colorVehiculo" value="${parqueadero.colorVehiculo}" type="text"
					placeholder="Color vehiculo" /> <br />
				
				<label for="marcaVehiculo">Marca</label> <input
					name="marcaVehiculo" id="marcaVehiculo" value="${parqueadero.marcaVehiculo}" type="text"
					placeholder="Marca vehiculo" /> <br />
				
				<label for="numApartamento">Apartamento</label> <input
					name="numApartamento" id="numApartamento" value="${parqueadero.apartamento}"type="text"
					placeholder="Número apartamento" /> <br />
				
				<label for="numTorre">Torre</label> <input
					name="numTorre" id="numTorre" value="${parqueadero.torre}" type="text"
					placeholder="Número torre" /> <br />
				
				<label for="claseVehiculo">Clase vehículo</label> <input
					name="claseVehiculo" id="claseVehiculo" value="${parqueadero.claseVehiculo}" type="text"
					placeholder="clase vehiculo" /> <br />
				
				
			</fieldset>
			<br /> <input type="submit" value="Guardar" />

		</form>
	</section>


</body>
</html>