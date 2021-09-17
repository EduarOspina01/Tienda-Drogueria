<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<title>Usuario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
body {
	background-image:
		url('https://image.freepik.com/vector-gratis/asistencia-sanitaria-medica-color-azul_1017-26800.jpg');
}

h3, p {
	color: #;
}
</style>

</head>
<body>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-success">
		<div class="collapse navbar-collapse" id="navbar">
			<ul class="navbar-nav">
				<li class="nav-item active"><a
					style="margin-left: 10px; border: none"
					class="btn btn-outline-light" href="Controlador?accion=Principal">Inicio</a></li><!-- Boton Navbar Inicio  -->
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light" href="Controlador?accion=Usuario">Usuarios</a></li><!-- Boton Navbar Usuario  -->
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light" href="Controlador?accion=Cliente">Clientes</a></li><!-- Boton Navbar Cliente  -->
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light" href="Controlador?accion=Proveedor">Proveedores</a></li><!-- Boton Navbar Proveedor  -->
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light" href="Controlador?accion=Producto">Productos</a></li><!-- Boton Navbar Productos  -->
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light" href="Controlador?accion=Ventas">Ventas</a></li><!-- Boton Navbar Ventas  -->
				<li class="nav-item"><a style="margin-left: 10px; border: none"
					class="btn btn-outline-light" href="Controlador?accion=Reporte">Reportes</a></li><!-- Boton Navbar Reportes  -->
			</ul>
		</div>
		<!-- Dropdown boton de sesion y fin de sesion  -->
		<div class="dropdown">
			<button style="border: none" class="btn btn-light dropdown-toggle"
				type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="true">${usuario.getNombre()}</button>
			<div class="dropdown-menu text-center"
				aria-labelledby="dropdownMenuButton1">
				<a class="dropdown-item" href="#"> <img src="img/user.png"
					alt="60" width="60">
				</a> <a class="dropdown-item" href="#">${usuario.getUsuario()}</a> <a
					class="dropdown-item" href="#">${usuario.getEmail()}</a>
				<div class="dropdown-divider"></div>
				<form action="Sesion" method="post">
					<button name="accion" value="Salir" class="dropdown-item" href="#">
						Salir</button>
				</form>
			</div>
		</div>
	</nav>
	<!-- Fin Navbar -->
	
	<!-- Formulario del CRUD para el Usuario -->
	<form action="CRUD" method="post" id="formUsuario">
		<p>
			Cédula: <input type="number" name="cedula">
		</p>
		<p>
			Nombre:<input type="text" name="nombre" id="idNombre">
		</p>
		<p>
			E-mail:<input type="e-mail" name="email" id="idEmail">
		</p>
		<p>
			Usuario : <input type="text" placeholder="Escribe Nombre" name="user">
		</p>
		<p>
			Contraseña: <input type="password"
				placeholder="Escriba su Contraseña" name="pass">
		</p>
		<p>
		<center>
			<input type="submit" value="Consultar" name="btnConsultar">
			</button>
			<p>
			<center>
				<input type="submit" value="Crear" name="btnCrear">
			</center>
			<p>
			<center>
				<input type="submit" value="Actualizar" name="btnActualizar">
			</center>
			<p>
			<center>
				<input type="submit" value="Borrar" name="btnBorrar">
			</center>
	</form>
	
	<!-- Script de bootstrap5  -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous">
		
	</script>
</body>
</html>