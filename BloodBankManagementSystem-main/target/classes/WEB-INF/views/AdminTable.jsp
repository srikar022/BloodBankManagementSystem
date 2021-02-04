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

<title>Admin Table</title>
<style>
.td {
	color: black;
}
</style>

</head>

<body>

	<center>
		<h3>Donor Details</h3>
	</center>
	<div class="col-md-10">

		<table class="table table-striped table-dark">

			<tr>

				<th>Patient Id</th>

				<th>Patient Name</th>

				<th>Time Of the Day</th>

				<th>Glucose Levels</th>

				<th>Notes</th>

				<th>Status</th>
				<th colspan="2">Action</th>
			</tr>

			<c:forEach items="${DList}" var="donor">

				<tr>

					<td>${donor.patient_id}</td>

					<td>${donor.patientname}</td>

					<td>${donor.time_of_the_day}</td>

					<td>${donor.glucose_level}</td>

					<td>${donor.notes}</td>

					<td>${donor.status}</td>

					<td><a
						href="<c:url value='/DonorAcceptStatus/${donor.patient_id}'/>">
							<button id="button" class="btn btn-success" type="submit">Accept</button>
					</a></td>
					<td><a
						href="<c:url value='/DonorRejectStatus/${donor.patient_id}'/>">
							<button id="button" class="btn btn-danger" type="submit">Reject</button>
					</a></td>




				</tr>



			</c:forEach>

		</table>
	</div>

	<center>
		<h3>Requestor Details</h3>
	</center>
	<div class="col-md-3">

		<table class="table table-striped table-dark table-sm">

			<tr>

				<th>Requestor Id</th>

				<th>Patient Name</th>

				<th>Required Blood Group</th>

				<th>City</th>

				<th>Doctor Name</th>

				<th>Hospital Address</th>
				<th>Date Of Requirement</th>
			
				<th>Contact Number</th>
				<th>Email-Id</th>
				<th>Message</th>
				<th>Status</th>
				<th colspan="2">Action</th>
			</tr>

			<c:forEach items="${RList}" var="requestor">

				<tr>

					<td>${requestor.id}</td>

					<td>${requestor.patientname}</td>

					<td>${requestor.required_blood_group}</td>

					<td>${requestor.city}</td>

					<td>${requestor.doctor_name}</td>

					<td>${requestor.hospital_address}</td>

					<td>${requestor.date_of_requirement}</td>
				
					<td>${requestor.contact_number}</td>
					<td>${requestor.email_id}</td>
					<td>${requestor.message}</td>
					<td>${requestor.status}</td>
					<td><a href="<c:url value='/AcceptStatus/${requestor.id}'/>">
							<button id="button" class="btn btn-success" type="submit">Accept</button>
					</a></td>
					<td><a href="<c:url value='/RejectStatus/${requestor.id}'/>">
							<button id="button" class="btn btn-danger" type="submit">Reject</button>

					</a></td>

				</tr>



			</c:forEach>

		</table>
	</div>

</body>

</html>