<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Management | Edit</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");

	if (request.getSession().getAttribute("authorized") == null) {
		response.sendRedirect("index.jsp");
	}
	%>
	<%int imageId = Integer.parseInt(request.getParameter("imageId"));
	request.getSession().setAttribute("imageId",imageId);
	%>
	<div class="upload">
		<form action="<%=request.getContextPath()%>/edit" method="post"
			enctype="multipart/form-data">

			<label>Enter Image name: </label> <input type="text" name="imagename"
				placeholder="image name here.." required> <br>

			<div class="container">
				<input type="file" id="upload " name="image" accept="image/*"
					required>
			</div>
			<br> <input type="submit" id="uploadbtn" value="Edit"><br>
		</form>
	</div>
</body>
</html>