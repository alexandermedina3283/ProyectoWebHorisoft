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
        <h1> Formulario de registro residentes</h1>
        <h3> Sección uno</h3>
        <form action="http://localhost:8080/CRUD-usuario/ApartamentoController" method="post">
        <input type="hidden" name="opcion" value="guardar">
           <fieldset>
           
           <legend>Datos del apartamento </legend>
            
           <label for="apartamento">Apartamento</label>
           <input name="apartamento" id="apartamento" 
type= "number" placeholder="Digite numero apartamento" required autofocus/>
           <br />
           
           <label for="torre">Torre</label>
           <input name="torre" id="torre" 
type="text" placeholder="Digite numero torre" required/>
           <br />
           
            <label>Estado cartera</label>
            <input name="cartera" id="cartera" list="estado_cartera" required/>
            <datalist id="estado_cartera">
               <option value="Al día"/>
               <option value="En mora"/>                
            </datalist>
           
           </fieldset>
           <br />
           <input type="submit" value="Guardar"/>          
            
        </form>
    </section>


</body>
</html>