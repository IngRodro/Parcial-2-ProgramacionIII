<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ControllerUser" method="post">
				<label>Usuario</label> 
			<input type="text" name="user" required> 
				<label>Password</label> 
			<input type="password" name="pass" required>
			<button name="btnLogin" value="Login">Iniciar Sesion</button>
		</form>
</body>
</html>