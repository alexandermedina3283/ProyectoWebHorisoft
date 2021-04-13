<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar usuario</title>
<style>
body{
font-family: Arial;
}
.registrouser{
	background: #f2f2f2;
	height: 1000px;
	padding: 5px;
}

.registrouser h2{
padding: 10px;
color: #414141;
font-size: 25px;
text-align: left;
}

fieldset{
display: block;
margin-left: 2px;
margin-right: 2px;
padding-top: 0.35em;
padding-bottom: 0.625em;
padding-left: 0.75em;
padding-right: 0.75em;
border: 3px groove (internal value);
background-color: #D8A460;
width: 40%;
height: 450px;
}

legend{
background-color: gray;
color: white;
padding: 5px 10px;
}

input {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}

label{
width: 130px;
display: block;
margin-bottom: 0px;
margin-top: 10px;
}
</style>
</head>
<body>


<section class="logo">
			<img src="img/Cabecero.png" alt="">
			<h1 > Actualizar informacion del usuario</h1>
</section>


<section class="registrouser">
			<div class="contenedor">
				<h2 class="formulario">Diligencie el formulario en su totalidad</h2>
				<form action="http://localhost:8080/CRUD-usuario/UsuarioController" method="post">
				<c:set var="usuario" value="${usuario}"></c:set>
				<input type="hidden" name="opcion" value="editar">
				<input type="hidden" name="idUsuario" value="${usuario.idUsuario}">
					<fieldset>
						<legend>Formulario registro</legend>
						<label for="usuarionom">Nombre usuario :</label>
					<input type="text" name="nombreUsuario" id="nombreUsuario" value="${usuario.nombreUsuario}" 
					placeholder="nombre usuario" autofocus="" > <br>
					<label for="contra">Contraseña :</label>
					<input type="password" name="contraUsuario" id="contraUsuario" value="${usuario.contrasena}" 
					placeholder="ingrese contraseña" > <br>
					<label for="estadouser">Estado usuario:</label>
					<input list="estado_usuario" name="estadoUsuario" id="estadouser" value="${usuario.estadoUsuario}" 
					placeholder="seleccione estado" ><datalist id="estado_usuario">
					<option value = "Activo"></option>
					<option value = "Inactivo"></option>
					</datalist> <br>
					<label for="rol">Tipo usuario:</label>
					<input list="rol_usuario" name="rolUsuario" id="rol" value="${usuario.rolUsuario}"
					placeholder="Seleccione tipo usuario" ><datalist id= "rol_usuario">
						<option value = "Administrador Conjunto"></option>
						<option value = "Gestionador Zona"></option>
						<option value = "Residente"></option>
					</datalist> <br>
					<input type="submit" name= "botonEnviar" value="GUARDAR"/>
					</fieldset>
					
				</form>
			</div>
		</section>
</body>
</html>