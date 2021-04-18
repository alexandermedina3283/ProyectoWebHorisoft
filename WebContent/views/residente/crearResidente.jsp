<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro residente</title>
</head>
<body>

<section>
		<h1>Formulario de registro</h1>
		<form action="http://localhost:8080/CRUD-usuario/ResidenteController" method="post">
			<input type="hidden" name="opcion" value="guardar">
			<fieldset>

				<legend>Datos del residente</legend>

				<label for="nombreResidente">Nombre</label> <input
					name="nombreResidente" id="nombreResidente" type="text"
					placeholder="Escriba nombre residente" /> <br />
					
				<label for="apellidoResidente">Apellido</label> <input
					name="apellidoResidente" id="apellidoResidente" type="text"
					placeholder="apellido residente" /> <br />
					
				<label for="identificacionResidente">Identificación</label> <input
					name="identificacionResidente" id="identificacionResidente" type="text"
					placeholder="numero identificacion CC########" /> <br />
					
				<label for="fechaNacimientoResidente">Fecha nacimiento</label> <input
					name="fechaNacimiento" id="fechaNacimiento" type="date"
					placeholder="fecha de nacimiento" /> <br />
					
				<label for="telefonoResidente">Telefono</label> <input
					name="telefonoResidente" id="telefonoResidente" type="text"
					placeholder="telefono residente" /> <br />
					
				<label for="emailResidente">Correo electronico</label> <input
					name="emailResidente" id="emailResidente" type="text"
					placeholder="correo electronico residente" /> <br />
					
				<label for="estadoResidente">Estado residente</label>	
				<input list="estado" name="estadoResidente" id="estadoResidente" 
					placeholder="Seleccione estado" >
					
					<datalist id= "estado">
						<option value = "Activo"></option>
						<option value = "Inactivo"></option>						
					</datalist> <br>
					
				<label for="numApartamento">Apartamento</label> <input
					name="numApartamento" id="numApartamento" type="text"
					placeholder="Número apartamento" /> <br />
				
				<label for="numTorre">Torre</label> <input
					name="numTorre" id="numTorre" type="text"
					placeholder="Número torre" /> <br />
					
					
				<label for="categoriaResidente">Categoria residente</label> 				
					<select name="categoriaResidente" id="categoriaResidente">				
						<option value="1">Propietario</option>
						<option value="2">Arrendatario</option>
						<option value="3">Nucleo propietario</option>
						<option value="4">Nucleo arrendatario</option>									
					</select>
					
				
			</fieldset>
			<br /> <input type="submit" value="Guardar" />

		</form>
	</section>

</body>
</html>