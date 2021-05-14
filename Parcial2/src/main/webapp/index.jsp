<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js&quot"
	; integrity="
	sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
	crossorigin="anonymous"></script>
<body>

<script type="text/javascript">
				$(document).ready(function () {
					$.post('ControllerConsulta', {
					}, function (response) {
						let datos = JSON.parse(response);

						console.log(datos);

						var tabla = document.getElementById('tablaConsulta');
						for (let item of datos) {
							tabla.innerHTML += `
					<tr>
						<td>${item.Id}</td>
						<td>${item.Nombre}</td>
						<td>${item.Apellido}</td>
						<td><a class="btn btn-danger" href="ControllerConsulta?Id=${item.Id}&Eliminar=btnEliminar">Eliminar</a>
						</td>
					</tr>
					`
						}
					});
				});
			</script>
<form action="ControllerUser" method="post">
<button name="btniniciar" value="Iniciar">Iniciar Sesion</button>

<button name="btncerrar" value="Cerrar">Cerrar Sesion</button>
</form>
<table >
			<thead>
				<th>ID</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Acciones</th>
			</thead>
			<tbody id="tablaConsulta">

			</tbody>
		</table>

</body>
</html>
