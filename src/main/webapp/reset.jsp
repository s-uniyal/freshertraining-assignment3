<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Management | Reset</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">

</head>
<body>
	<div class="container">

		<form action="<%=request.getContextPath()%>/reset" method="post">
			<div class="form-group">
				<label>Name:</label> <input type="text" class="form-control"
					placeholder="Full Name" name="name" required><br>
			</div>
			<div class="form-group">
				<label>User Name:</label> <input type="text" placeholder="User Name"
					class="form-control" name="username" required><br>
			</div>
			<div class="form-group">
				<label>New Password:</label> <input type="password"
					class="form-control" placeholder="Password" name="new_password"
					required><br>
			</div>
			<div class="form-group">
				<label>Confirm password</label> <input type="password"
					class="form-control" placeholder="Password" name="conf_password"
					required><br>
			</div>
			<a href="index.jsp" class="btn btn-info">back to login</a>

			<button type="submit" class="btn btn-primary">Reset</button>
			<br>

		</form>
	</div>

</body>
</html>