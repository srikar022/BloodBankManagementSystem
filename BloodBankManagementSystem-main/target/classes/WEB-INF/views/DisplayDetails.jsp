<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Blood / Donor Availability</title>


</head>

<body>

	<center>
		<h3>Blood / Donor availability</h3>
	</center>
	<br>
	<table class="table table-striped table-dark">

		<tr>

			<th>UserId</th>

			<th>First Name</th>

			<th>Last Name</th>

			<th>Blood Group</th>

			<th>City</th>


		</tr>

		<c:forEach items="${AvailableList}" var="check">

			<tr>

				<td>${check.id}</td>

				<td>${check.firstname}</td>

				<td>${check.lastname}</td>

				<td>${check.bloodgroup}</td>

				<td>${check.city}</td>






			</tr>



		</c:forEach>

	</table>

</body>

</html>