<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Horisoft</title>

<style>
header h2{

	font-family: Arial;
	font-size: 30px;
	font-weight: 300;
	color: #EF7F1A;
}

nav{
height: 250px;
font-family: Arial;
}

footer{
	background:#414141;
	margin: auto;
	overflow: hidden;
	text-align: center;
	height: 115px;
	 }
 .contenedor.footer{	
 	display: flex;
 	justify-content: space-between;
 	padding: 20px;
 	color: #EF7F1A;
 }
footer>h2{
color: #fff;
font-size: 15px;
font-weight: 500;
margin-bottom: 15px;
text-align: left;

}
</style>
</head>

<body>

<header>
<section class="logo">
<img src="img/Cabecero.png" alt="">
<h2>Gestiona la informacion de tus residentes y las zonas sociales</h2>
<h2>Con un sistema de información funcional e intuitivo</h2>
</section>
</header><br>

<nav>
<h1>Menu principal</h1>
	<table>
		<tr>
			<td> <a href="http://localhost:8080/CRUD-usuario/UsuarioController?opcion=crear">Crear usuario</td>
		</tr>
		<tr>
			<td><a href="http://localhost:8080/CRUD-usuario/UsuarioController?opcion=listar">Mostrar usuarios</td>
		</tr>
		<tr>
			<td><a href="http://localhost:8080/CRUD-usuario/ApartamentoController?opcion=crearapartamento">Crear apartamento</td>
		</tr>
		<tr>
			<td><a href="http://localhost:8080/CRUD-usuario/ApartamentoController?opcion=listarapartamento">Mostrar apartamento</td>
		</tr>
	</table><br>
</nav>
		
<footer>
		<div class="contenedor footer">
			<div class="content-footer">
				<h4>Telefono</h4>
				<p>3202115906</p>
			</div><br>
			<div class="content-footer">
				<h4>Mail</h4>
				<p>contactenos@horisoft.com</p>
			</div><br>
			<div class="content-footer">
				<h4>Direccion</h4>
				<p>Avenida 127 # 12 -65</p>
			</div><br>
		</div>
</footer>		
			
	

</body>
</html>