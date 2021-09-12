<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<title>Usuario</title>
<style>
		body{background-image:url('https://image.freepik.com/vector-gratis/asistencia-sanitaria-medica-color-azul_1017-26800.jpg');
		}
		h3, p {
		color:#;
		}
		</style>

</head>
<body>
<form action ="CRUD" method="post" id="formUsuario">
<p>Cédula: <input  type="number" name = "cedula"></p>
<p>Nombre:<input type="text" name = "nombre" id ="idNombre"></p>
<p>E-mail:<input type="e-mail" name ="email" id = "idEmail"></p>
<p>Usuario : <input type="text" placeholder="Escribe Nombre" name ="user"></p>
<p>Contraseña: <input type="password" placeholder="Escriba su Contraseña" name ="pass"></p>
<!--<p> <center> <button>Consultar</center></button>         
<p> <center> <button>  Crear </center> </button>
<p> <center> <button>Actalizar</center></button>         
<p> <center> <button>  Borrar </center> </button>
-->
 <p> <center> <input type = "submit" value="Consultar" name = "btnConsultar"></button>         
<p> <center> <input type = "submit" value="Crear" name = "btnCrear"></center>
<p> <center> <input type = "submit" value="Actualizar" name = "btnActualizar"></center>         
<p> <center> <input type = "submit" value="Borrar" name = "btnBorrar"></center>

</form>
</body>
</html>