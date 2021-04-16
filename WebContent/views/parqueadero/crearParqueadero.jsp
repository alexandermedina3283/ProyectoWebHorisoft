<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro parqueadero vehiculo</title>
</head>
<body>

<section>
		<h1>Formulario de registro</h1>
		<form action="http://localhost:8080/CRUD-usuario/ParqueaderoController" method="post">
			<input type="hidden" name="opcion" value="guardar">
			<fieldset>

				<legend>Datos del parqueadero - vehiculo </legend>

				<label for="idParqueadero">Numero parqueadero</label> <input
					name="idParqueadero" id="idParqueadero" type="text"
					placeholder="Escriba número parqueadero" /> <br />
					
				<label for="ubicacionParqueadero">Ubicación</label> <input
					name="ubicacionParqueadero" id="ubicacionParqueadero" type="text"
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
					name="placaVehiculo" id="placaVehiculo" type="text"
					placeholder="Placa vehiculo" /> <br />
				
				<label for="modeloVehiculo">Modelo</label> <input
					name="modeloVehiculo" id="modeloVehiculo" type="text"
					placeholder="Modelo vehiculo" /> <br />
				
				<label for="colorVehiculo">Color</label> <input
					name="colorVehiculo" id="colorVehiculo" type="text"
					placeholder="Color vehiculo" /> <br />
				
				<label for="marcaVehiculo">Marca</label> <input
					name="marcaVehiculo" id="marcaVehiculo" type="text"
					placeholder="Marca vehiculo" /> <br />
				
				<label for="numApartamento">Apartamento</label> <input
					name="numApartamento" id="numApartamento" type="text"
					placeholder="Número apartamento" /> <br />
				
				<label for="numTorre">Torre</label> <input
					name="numTorre" id="numTorre" type="text"
					placeholder="Número torre" /> <br />
				
				<label for="claseVehiculo">Clase vehiculo</label> 
				
				<select name="claseVehiculo" id="claseVehiculo">				
				<option value="1">Automovil</option>
				<option value="2">Motocicleta</option>
				<option value="3">Camioneta</option>
				<option value="4">Taxi</option>
				<option value="5">Vans</option>				
				</select>
				
			</fieldset>
			<br /> <input type="submit" value="Guardar" />

		</form>
	</section>


</body>
</html>