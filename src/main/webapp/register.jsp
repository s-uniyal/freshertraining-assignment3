<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Management | Register</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<form action="<%=request.getContextPath()%>/register" method="post">
			<div class="form-group">
				<label>Name:</label> <input type="text" placeholder="Full Name"
					class="form-control" name="name" required><br>
			</div>
			<div class="form-group">
				<label>User Name:</label> <input type="text" placeholder="User Name"
					class="form-control" name="username" required><br>
			</div>
			<div class="form-group">
				<label>Password:</label> <input type="password" class="form-control"
					placeholder="Password" name="password" required><br>
			</div>
			<a href="index.jsp" class="btn btn-info btn-xs">back to login</a>

			<button type="submit" class="btn btn-primary btn-xs">Register</button>
			<br>

		</form>
	</div>
</body>
</html>