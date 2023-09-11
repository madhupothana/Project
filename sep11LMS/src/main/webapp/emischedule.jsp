<%@ page language="java" import="java.time.LocalDate" contentType="text/html; charset=ISO-8859-1"
    import="java.util.ArrayList,com.model.LoanDetails"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Applicant List</title>

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

table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

th {
    background-color: #f2f2f2;
}
</style>
</head>
<body>
	<% double loana=400000; %>
	<% double emi=Double.parseDouble(request.getParameter("amt")); %>
	<% int months=Integer.parseInt(request.getParameter("span")); %>
	<% double cum=0; %>
    <div class="container">
        <h1>Emi Schedule</h1>


        <!-- Table -->
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>emi</th>
                    <th>cummulative</th>
            </thead>
            <tbody>
                <%
                LocalDate d=LocalDate.now();
                
                for (int i=0;i<months;i++) {
                	
               	
                %>

                <tr>
     
                    <td><%=d%></td>
                    <td><%=emi%></td>
                    <td><%=cum%></td>
                </tr>

                <%
                cum+=emi;
            	d=d.plusMonths(1);
                }
                %>
            </tbody>
        </table>
    </div>

    <!-- Include Bootstrap JS and jQuery (if needed) for Bootstrap functionality -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- JavaScript for Filtering and Downloading Excel -->
</body>
</html>