<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 0;
}

.header {
	padding: 80px;
	text-align: center;
	background-image:
		url("http://www.cpbb.org/assets/images/donation-locations.png");
	background-size: 100% 100%;
	color: white;
}

.header h1 {
	font-size: 40px;
}

.navbar {
	overflow: hidden;
	background-color: #333;
}

.navbar a {
	float: left;
	display: block;
	color: white;
	text-align: center;
	padding: 14px 20px;
	text-decoration: none;
}

.navbar a.right {
	float: right;
}

.navbar a:hover {
	background-color: #ddd;
	color: black;
}

.row {
	display: flex;
	flex-wrap: wrap;
}

.side {
	flex: 20%;
	background-color: #7c7c7c;
	padding: 20px;
}

.main {
	flex: 60%;
	background-color: white;
	padding: 20px;
}

.rightside {
	flex: 20%;
	background-color: #7c7c7c;
	padding: 20px;
}

.img {
	background-image: url("images/images.jfif");;
	width: 100%;
	padding: 20px;
}

.footer {
	padding: 20px;
	text-align: left;
	background-color: #333;
	color: white;
}
</style>
</head>
<body>
	<div class="header">
		<h1>Welcome</h1>
		<p>Blood Bank</p>
	</div>
	<div class="navbar">
		<a href="UserRegistration" target="center">User Registration</a> <a
			href="CheckBloodAvailability" target="center">Check Blood
			Availability</a> <a href="RequestBloodAndCheckStatus" target="center">Request
			Blood </a> <a href="DonateBloodAndCheckStatus" target="center">Donate
			Blood</a> <a href="RCheckStatus" target="center">Request Blood Check
			Status</a> <a href="DCheckStatus" target="center">Donate Blood Check
			Status</a> <a href="Admin" target="center">Admin</a> <a href="#maps">Contact Us</a>
	</div>

	<div class="row">
		<div class="rightside">
			<div class="img" style="height: 200px;">Facts</div>
			<h2>Facts</h2>
			<h3>About Listening</h3>

			<p>According to the American Red Cross: About 36,000 units of
				blood are needed every day. The number of blood units donated is
				about 13.6 million a year. About 6.8 million volunteers are blood
				donors each year. Each unit of blood is broken down into components.
				These are red blood cells, plasma, cryoprecipitated AHF (cryo), a
				white blood cell called a granulocyte, and platelets. One unit of
				whole blood and its parts may be transfused to several people. Each
				person may have a different need. More than 21 million blood
				components are transfused each year.</p>

			<div class="img" style="height: 60px;">DONATE BLOOD</div>
			<br>
			<div class="img" style="height: 60px;">SAVE LIVES</div>
			<br>
			<div class="img" style="height: 60px;">HELP THE NEEDY</div>
		</div>
		<div class="main" style="background-image: url('images/54a6d3001f64eeb3a1a19eeb5266a028.jpg');">
			<h2>BLOOD BANK MANAGEMENT SYSTEM</h2>
			<h5>Donate Blood And Save A Life</h5>
			<div class="img" style="height: 200px;">ABOUT</div>
			<p>Blood Bank Management system is the management of all the
				modules required for saving blood.It is like a repository where it
				stores all the details of the all the modules of Blood.A blood bank
				is a center where blood gathered as a result of blood donation is
				stored and preserved for later use in blood transfusion. The term
				"blood bank" typically refers to a division of a hospital where the
				storage of blood product occurs and where proper testing is
				performed (to reduce the risk of transfusion related adverse
				events). However, it sometimes refers to a collection center, and
				indeed some hospitals also perform collection. Blood banking
				includes tasks related to blood collection, processing, testing,
				separation, and storage.</p>
			<p>There are basically few modules which are listed out below for
				the management of blood.</p>
			<ul>
				<li>Home Page</li>
				<li>Registration Page</li>
				<li>Request Blood Page</li>
				<li>Donate Blood Page</li>
				<li>Request Status Page</li>
				<li>Donor Status Page</li>
				<li>Contact Us</li>
			</ul>
			<br>
			<p>The System is a multi disciplinary, evidence-based approach to
				optimizing the care of patients who might need a blood
				transfusion.Blood management represents an international initiative
				in best practice for transfusion medicine that is supported by the
				World Health Organization (WHO).Establishing a patient blood
				management strategy requires leadership and support from national
				and regional government policy makers and managers, health care
				professionals, and patients. Patients are an essential part of
				planning, implementing and evaluating Blood Management Programs.</p>
		</div>
		<div class="rightside">
			<div class="img" style="height: 200px;">Blood Donors</div>
			<h2>Who Are The</h2>
			<h3>Blood Donors</h3>

			<p>Most blood donors are volunteers. But you may also donate
				blood several weeks before having surgery. This is so that your
				blood is available in case you need a transfusion. Donating blood
				for yourself is called an autologous donation. Volunteer blood
				donors must meet certain criteria. These include: Must be at least
				16 years of age, or the minimum age set by state law Must be in good
				health Must weigh at least 110 pounds Must pass the physical and
				health history exam given before donation Some states let people
				younger than 16 or 17 years to donate blood, with parental consent.</p>

			<div class="img" style="height: 60px;">DONATE BLOOD</div>
			<br>
			<div class="img" style="height: 60px;">SAVE LIVES</div>
			<br>
			<div class="img" style="height: 60px;">HELP THE NEEDY</div>
		</div>
	</div>
	<section id="maps">
	<div class="footer">
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d30712057.306560654!2d64.400691212374!3d20.007237393514643!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x30635ff06b92b791%3A0xd78c4fa1854213a6!2sIndia!5e0!3m2!1sen!2sin!4v1602727587862!5m2!1sen!2sin"
			width="100%" height="380" frameborder="0" style="border: 0"
			allowfullscreen></iframe>
	</div>
	</section>
	<div class="footer">
		<h5>Contact  : 9848032919</h5>
		 
		<h5>Location : Bangalore,India</h5>
	</div>

	<br>
	<br>
	<br>
	<br>



</body>
</html>