<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<section>
		<h1>Formulario de registro</h1>
		<form
			action="http://localhost:8080/CRUD-usuario/MascotaController" method="post">
			<input type="hidden" name="opcion" value="guardar">
			<fieldset>

				<legend>Datos de la mascota </legend>

				<label for="nombreMascota">Nombre</label> <input
					name="nombreMascota" id="nombreMascota" type="text"
					placeholder="Digite nombre mascota" /> <br />
					
				<label for="claseMascota">Clase</label> <input
					name="claseMascota" id="claseMascota" type="text"
					placeholder="Digite clase de mascota" /> <br />
					
				<label for="numApartamento">Numero apartamento</label> <input
					name="numApartamento" id="nunApartamento" type="number"
					placeholder="Digite numero apartamento" /> <br />
					
				<label for="numTorre">Numero torre</label> <input
					name="numTorre" id="nunTorre" type="text"
					placeholder="Digite numero torre" /> <br />
									

			</fieldset>
			<br /> <input type="submit" value="Guardar" />

		</form>
	</section>


</body>
</html>