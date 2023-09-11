<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Include Bootstrap CSS -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<!-- Include Bootstrap JS (optional) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

.header {
	background-color: #333;
	color: #fff;
	text-align: center;
	padding: 10px;
	position: relative;
}

/* Style for SignIn and SignUp buttons */
.header button {
	background-color: #007bff;
	color: #fff;
	border: none;
	padding: 5px 10px;
	cursor: pointer;
	position: absolute;
	top: 10px;
}

.open-button {
	background-color: #555;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	opacity: 0.8;
	position: fixed;
	bottom: 23px;
	right: 28px;
	width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	border: none;
	background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus
	{
	background-color: #ddd;
	outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
	opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
	background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
	opacity: 1;
}

/* Adjust the right position for SignUp button */
.header button.signup {
	right: 30px;
	margin-top: 30px;
}

.header button.signin {
	right: 130px;
	margin-top: 30px;
}

/* Add spacing between the buttons */
.header button+button.signup {
	margin-left: 10px;
}

/* Hospital section */
.hospital {
	text-align: center;
	padding: 20px;
}

.facility {
	display: flex;
	justify-content: flex-start;
	align-items: center;
	margin-bottom: 20px;
}

.facility img {
	max-width: 40%;
	height: auto;
	border-radius: 5px;
	margin-right: 20px;
}

.facility p {
	font-size: 18px;
	color: #333;
	text-align: left;
}
#id1{

margin-left:400px;
margin-top:60px;}
#id2{
margin-left:500px;margin-top:60px;}
</style>
<meta charset="ISO-8859-1">
<title>MSB Bank</title>
</head>
<body>
	<div class="header bg-dark text-white py-3">
    <h1 class="text-center">MSB Bank</h1>
    
   <form action="customerlogin"><button id="id1" >Customer</button></form>&nbsp;&nbsp;&nbsp;
    <form action="admin"><button id="id2">Admin</button></form> 
</div>

<div class="container mt-5">
    <div class="row">
        <div class="col-lg-6 offset-lg-3">
            <div class="hospital">
                <h2 class="text-center">Why Choose MBS Bank?</h2>
                <p class="text-center">Established by Dr. Prathap C Reddy in 1983, MBS Bank has a robust presence across the healthcare ecosystem. From routine wellness & preventive health care to innovative life-saving treatments and diagnostic services, Apollo Hospitals has touched more than 200 million lives from over 120 countries.</p>
            </div>
        </div>
    </div>
</div>

<div class="container mt-5">
    <div class="row">
        <div class="col-lg-4">
                        <img src="/facility1.jpg" alt="Facility 1" class="img-fluid rounded">
        
            <div class="facility">
                <p>It has been brought to our notice that some people have received emails purporting to offer money for kidney donation and misusing the name of Apollo Hospitals...</p>
            </div>
        </div>
        <div class="col-lg-4">
                        <img src="images/facility2.jpg" alt="Facility 2" class="img-fluid rounded">
        
            <div class="facility">
                <p>I added a new section with the class hospital to contain the images and descriptions...</p>
            </div>
        </div>
        <div class="col-lg-4">
                        <img src="images/facility3.jpg" alt="Facility 3" class="img-fluid rounded">
        
            <div class="facility">
                <p>I added a new section with the class hospital to contain the images and descriptions...</p>
            </div>
        </div>
    </div>
</div>



</body>
</html>