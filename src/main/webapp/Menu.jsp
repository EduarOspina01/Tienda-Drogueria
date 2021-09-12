<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<title>Tienda Genérica</title>
<script>
function redireccion(){
	location.href = 'Usuario.jsp'
}
</script>
<style>
body {
	background-image:
		url('https://image.freepik.com/vector-gratis/asistencia-sanitaria-medica-color-azul_1017-26800.jpg');
}

h3, p {
	color: red;
}
</style>
</head>
<body>
	<h3>
		<center>TIENDA DRUGSTORE</center>
	</h3>
	<ul class="Menu">
		<!--<a href="http://localhost:8080/project/Usuario.jsp">--><button name = "btnUser" onclick ="javascript:redireccion();">Usuario</button></a>
		<button>Clientes</button>
		<button>Proveedores</button>
		<button>Productos</button>
		<button>Ventas</button>
		<button>Reportes</button>
	</ul>
</body>
</html>
