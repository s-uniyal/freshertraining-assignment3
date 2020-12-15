<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Management | Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="container">
		<form action="<%=request.getContextPath()%>/login" method="post">
			<div class="form-group">
				<label>User Name:</label> <input type="text" class="form-control"
					placeholder="User Name" name="username" class="form-control"
					required><br>
			</div>
			<div class="form-group">
				<label>Password:</label> <input type="password"
					placeholder="Password" name="password" class="form-control"
					required><br>
			</div>
			<a href="reset.jsp" class="btn btn-info btn-xs">Forgot password?</a>
			<a href="register.jsp" class="btn btn-info btn-xs">Register</a>

			<button type="submit" class="btn btn-primary">>Login</button>

		</form>
	</div>
</body>
</html>