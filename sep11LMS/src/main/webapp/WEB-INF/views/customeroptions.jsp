<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>MSB Bank</title>
    
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

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
        }

        .container {
            text-align: center;
            margin-top: 50px;
        }

        /* Style for SignIn and SignUp buttons */
        .btn-primary {
            margin: 10px;
        }
    </style>
</head>
<body>
    <div class="header bg-dark text-white py-3">
        <h1 class="text-center">MSB Bank</h1>
    </div>
    
    <div class="container">
        <form action="newapplication" class="d-inline-block">
            <button type="submit" class="btn btn-primary">Start New Application</button>
        </form>
        <form action="check" class="d-inline-block">
            <button type="submit" class="btn btn-primary">Check Loan Eligibility</button>
        </form>
    </div>
</body>
</html>