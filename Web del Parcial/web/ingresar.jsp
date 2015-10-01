<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximun-scale=1">

	<meta name="author" content="Lucking">
	<meta name="description" content="ingresar.html">
	<title>ingresar.html</title>
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/comun_estilos.css">
	<link rel="stylesheet" href="css/ingresar_estilos.css">
	<script src="css/modernizr.custom.24970.js"></script>
</head>
<body>
	<header>
		<nav>
			<img src="imagenes/logo.png" />
			<ul>
				<li><a href="home.jsp">Home</a></li>
				<li><a href="crear_articulo.jsp">Post an Article</a></li>
				<li><a href="faq.jsp">FAQ</a></li>
				<li><a href="ingresar.jsp">Salir</a></li>
			</ul>
		</nav>
	</header>

	<section>
		<h1>Ingresar</h1>
		<article>
			<form action="ServletUser" method="post">
                            <input type="hidden" name="peticion" value="login" />
                            <label>Usuario:</label>
                            <input name="usuario" type="text" />
                            <label>ContraseÃ±a:</label>
                            <input name="contrasena" type="text" />
                            <div name="div_errores">
                            </div>
                            <input name="acceder" type="submit" value="Acceder" />
			</form>
		</article>
	</section>
</body>
</html>