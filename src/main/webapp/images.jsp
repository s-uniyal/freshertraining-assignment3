<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.IOException"%>
<%@page import="com.nagarro.freshertraining.assignment3.models.User"%>
<%@page import="com.nagarro.freshertraining.assignment3.models.Image"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Management | Gallery</title>
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
	<div class="logout">
		<form action="<%=request.getContextPath()%>/logout">
			<input type="submit" value="logout" class="btn btn-primary btn-xs"
				name="logout">
		</form>
	</div>
	<div class="upload">
		<form action="<%=request.getContextPath()%>/upload" method="post"
			enctype="multipart/form-data">

			<label>Enter Image name: </label> <input type="text" name="imagename"
				placeholder="image name here.." required> <br>

			<div class="container">
				<input type="file" id="upload " name="image" accept="image/*"
					required>
			</div>
			<br> <input type="submit" id="uploadbtn" value="Upload"><br>
		</form>
	</div>

	<form action="<%=request.getContextPath()%>/RetrieveImage">
		<%
			/* 	 Collection <Image> images = (Collection<Image>) request.getSession().getAttribute("images"); */
		%>

		<!-- This will be in a for loop for all the images there are  -->
		<div class="container" class="table-responsive">
			<table class="table table-hover">

				<thead class="thead-dark">
					<tr>
						<th>S.No.</th>
						<th>Image Name</th>
						<th>Image Preview</th>
						<th>Image Size</th>
						<th>Actions</th>
					</tr>
				</thead>
				<c:set var="count" value="${0}" scope="page"></c:set>
				<c:set var="size" value="${0}" scope="page"></c:set>
				<tbody>
					<c:forEach var="image" items="${images}">
						<tr>
							<td>${count+1}</td>
							<td>${image.getImageName()}</td>
							<td><img class="img-thumbnail"
								src="data:image/png;base64,${Base64.getEncoder().encodeToString(image.getImage())}"
								width="300" height="150" alt="image not found"></td>
							<td>${image.getImageSize()}Kb</td>
							<td>
								<ul>
									<li><a href="delete?imageId=${ image.getImageId()}">Delete</a></li>
									<li> <a href="edit.jsp?imageId=${image.getImageId() }">Edit</a></li>
								</ul>
							</td>
							<c:set var="count" value="${count+1}" scope="page"></c:set>

							<c:set var="size" value="${size + image.getImageSize()/1024}"
								scope="page"></c:set>

						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>

						<td id="align">Total Size: <fmt:formatNumber type="number"
								maxFractionDigits="2" value="${size}" /> Mb
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</form>
</body>
</html>