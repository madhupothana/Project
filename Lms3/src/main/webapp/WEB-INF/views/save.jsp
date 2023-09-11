<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
/* Reset some default browser styles */
body {
	margin: 0;
	padding-top: 100px;
}
.header {
	background-color: #333;
	color: #fff;
	text-align: center;
	padding: 10px;
	position: relative;
}
.form-container {
	max-width: 900px;
	margin: 0 auto;
	padding: 20px;
	border: 1px solid #ccc;
	background-color: #f9f9f9;
	border-radius: 5px;
}

/* Style the tabs */
.tabs {
	display: flex;
	justify-content: space-around;
	margin-bottom: 20px;
}

.tab {
	background-color: gray;
	color: #fff;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
	border-radius: 5px;
	transition: background-color 0.3s;
}

.tab.active-tab {
	background-color: #007bff;
}

/* Style the form box */
.form-box {
	background-color: #fff;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-part h2 {
	margin-bottom: 20px;
	color: #333;
}

input[type="text"] {
	width: 90%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	font-size: 16px;
}

input[type="date"] {
	width: 90%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	font-size: 16px;
}

input[type="tel"] {
	width: 90%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	font-size: 16px;
}

input[type="number"] {
	width: 90%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	font-size: 16px;
}

button.form-button {
	background-color: gray;
	color: #fff;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
	border-radius: 5px;
	transition: background-color 0.3s;
}

button.form-button:hover {
	background-color: #0056b3;
}

form:invalid {
	border-color: #ff0000;
}

#submission-message {
	color: #009900;
	font-weight: bold;
	margin-top: 10px;
}
</style>

</head>
<body>
<div class="header bg-dark text-white py-3">
		<h1 class="text-center">MSB Bank</h1>
	</div>
<center><h1>Application Submitted Successfully</h1></center>
</body>
</html>