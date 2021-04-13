<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  href="estilo.css"/>
</head>
<body>

<section class="registrouser">
			<div class="contenedor">
				<h2 class="titulo">Bienvenido</h2>
				<h2 class="formulario">Ingrese sus datos para acceder</h2>
				<form action="http://localhost:8080/CRUD-usuario/UsuarioController" method="post">
				<input type="hidden" name="opcion" value="validar">
					<fieldset>
						<legend>Formulario Ingreso</legend>
						<label for="usuarionom">Nombre usuario :</label>
					<input type="text" name="nombreUsuario" id="nombreUsuario" 
					placeholder="nombre usuario" autofocus="" > <br>
					<label for="contra">Contraseña :</label>
					<input type="password" name="contraUsuario" id="contraUsuario" 
					placeholder="ingrese contraseña" > <br>
					
					<input type="submit" name= "botonIngresar" value="INGRESAR"/>
					</fieldset>
					
				</form>
			</div>
		</section>

</body>
</html>