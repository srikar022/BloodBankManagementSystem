<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#button').click(function() {
			$('#myAlert').show('fade');
		});
	});
</script>
<style>
</style>
</head>
<body>
	<center>
		<h3>User Registration Form</h3>
	</center>
	<div id="myAlert" class="alert alert-info collapse">
		<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>Loading!!</strong>
	</div>
	<div class="col-md-5"
		style="background-image: url('images/54a6d3001f64eeb3a1a19eeb5266a028.jpg');">
		<form:form action="/BloodBankManagementSystem_SpringMVC/saveUser"
			method="post" commandName="UserForm" novalidate="novalidate"
			id="form">

			<div class="form-group">
				<label for="UserForm">First Name</label>
				<form:input path="firstname" class="form-control" id="UserForm"
					placeholder="Enter First Name" />
			</div>
			<div>
				<font color="red"><form:errors path="firstname" /></font>
			</div>
			<div class="form-group">
				<label for="UserForm">Last Name</label>
				<form:input path="lastname" class="form-control" id="UserForm"
					placeholder="Enter Last Name" />
			</div>
			<div>
				<font color="red"><form:errors path="lastname" /></font>
			</div>
			<div class="form-group">
				<label for="UserForm">User Name</label>
				<form:input path="username" class="form-control" id="UserForm"
					placeholder="Enter User Name" />
			</div>
			<div>
				<font color="red"><form:errors path="username" /></font>
			</div>
			<div class="form-group">
				<label for="UserForm">Password</label>
				<form:password path="password" class="form-control" id="UserForm"
					placeholder="Enter Password" />
			</div>
			<div>
				<font color="red"><form:errors path="password" /></font>
			</div>
			<div class="form-group">
				<label for="UserForm">Confirm Password</label>
				<form:password path="confirmpassword" class="form-control"
					id="UserForm" placeholder="Confirm Password" />
			</div>
			<div>
				<font color="red"><form:errors path="confirmpassword" /></font>
			</div>
			<div class="form-group">
				<label for="UserForm">Blood Group</label>
				<form:input path="bloodgroup" class="form-control" id="UserForm"
					placeholder="Enter Blood Group" />
			</div>
			<div>
				<font color="red"><form:errors path="bloodgroup" /></font>
			</div>
			<div class="form-group">
				<label for="UserForm">City</label>
				<form:input path="city" class="form-control" id="UserForm"
					placeholder="Enter City" />
			</div>
			<div>
				<font color="red"><form:errors path="city" /></font>
			</div>
			<button id="button" class="btn btn-primary" type="submit">Add
				User</button>

		</form:form>
	</div>
</body>
</html>