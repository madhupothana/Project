<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loan Applicant Form</title>

<!-- Include Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- Custom CSS for styling -->
<style>
/* Add your custom CSS styles here */
body {
	background-color: #f4f4f4;
}

.container {
	margin-top: 30px;
}

h1 {
	text-align: center;
	margin-bottom: 30px;
}

/* Add more custom styles as needed */
</style>
</head>
<body>
	<div class="container">
		<center>
			<h1>Loan Applicant Form</h1>
			<form action="listApplicants">
				<input type="submit" value="List Applicants">
			</form>
			</center>
	</div>
	

	<!-- Include Bootstrap JS and jQuery (if needed) for Bootstrap functionality -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>