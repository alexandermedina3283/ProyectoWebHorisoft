<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar mascota</title>
</head>
<body>

<section>
		<h1>Actualizar informacion de la mascota</h1>
		<form action="http://localhost:8080/CRUD-usuario/MascotaController" method="post">
			<c:set var="mascota" value="${mascota}"></c:set>
			<input type="hidden" name="opcion" value="editar">
			<input type="hidden" name="idMascota" value="${mascota.idMascota}">
			<fieldset>

				<legend>Datos de la mascota </legend>

				<label for="nombreMascota">Nombre</label> 
				<input name="nombreMascota" id="nombreMascota" value="${mascota.nombre}" type="text"
					placeholder="Digite nombre mascota" /> <br />
					
				<label for="claseMascota">Clase</label> <input name="claseMascota" id="claseMascota" value="${mascota.clase}" type="text"
					placeholder="Digite clase de mascota" /> <br />
					
				<label for="numApartamento">Numero apartamento</label> <input name="numApartamento" id="nunApartamento" value="${mascota.apartamento}" type="number"
					placeholder="Digite numero apartamento" /> <br />
					
				<label for="numTorre">Numero torre</label> <input name="numTorre" id="nunTorre" value="${mascota.torre}" type="text"
					placeholder="Digite numero torre" /> <br />
									

			</fieldset>
			<br /> <input type="submit" value="Guardar" />

		</form>
	</section>


</body>
</html>