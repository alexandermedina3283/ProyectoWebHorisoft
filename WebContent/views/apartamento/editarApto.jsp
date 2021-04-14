<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar apartamento</title>
</head>
<body>

	<section>
		<h1>Formulario de actualización residentes</h1>
		<h3>Sección uno</h3>
		<form action="http://localhost:8080/CRUD-usuario/ApartamentoController" method="post">
			<c:set var="apartamento" value="${apartamento}"></c:set>
			<input type="hidden" name="opcion" value="editar"> 
			<input type="hidden" name="apartamento" value="${apartamento.apartamento}">
			<input type="hidden" name="torre" value="${apartamento.torre}">

			<fieldset>

				<legend>Datos del apartamento </legend>

				<label for="apartamento">Apartamento</label> 
				<input name="apartamento" id="apartamento" value="${apartamento.apartamento}" type="number"
					placeholder="Digite numero apartamento" required autofocus /> <br />

				<label for="torre">Torre</label> 
				<input name="torre" id="torre" value="${apartamento.torre}" type="text" placeholder="Digite numero torre" required /> <br />

				<label>Estado cartera</label> <input name="cartera" id="cartera" value="${apartamento.estadoCartera}" list="estado_cartera" required />
				<datalist id="estado_cartera">
					<option value="Al día" />
					<option value="En mora" />
				</datalist>

			</fieldset>
			<br /> <input type="submit" value="Guardar" />

		</form>
	</section>


</body>
</html>