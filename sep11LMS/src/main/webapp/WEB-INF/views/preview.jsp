<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.model.Customer,com.model.Nominee,com.model.LoanDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Preview Details</title>
<!-- Include Bootstrap CSS -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #f8f9fa;
        padding: 20px;
    }

    .container {
        background-color: #ffffff;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
        text-align: center;
        margin-bottom: 30px;
    }

    .label-heading {
        font-weight: bold;
        color: #007bff;
    }

    h3 {
        color: #333;
    }
</style>
</head>
<body>
<form action="save" method="post">
<div class="container">
    <h1>Preview Details</h1>
    <% Customer c=(Customer)request.getAttribute("customer");
    Nominee n=(Nominee)request.getAttribute("nominee");
    LoanDetails l=(LoanDetails)request.getAttribute("loandetails"); %>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label class="label-heading">Customer Id:</label>
                <h3><%=c.getCust_id() %></h3>
            </div>
            <div class="form-group">
                <label class="label-heading">First Name:</label>
                <h3><%=c.getCust_firstname() %></h3>
            </div>
            <div class="form-group">
                <label class="label-heading">Last Name:</label>
                <h3><%=c.getCust_lastname() %></h3>
            </div>
            <div class="form-group">
                <label class="label-heading">DOB:</label>
                <h3><%=c.getCust_dob() %></h3>
            </div>
            <div class="form-group">
                <label class="label-heading">Pan no:</label>
                <h3><%=c.getCust_panno() %></h3>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label class="label-heading">Mobile:</label>
                <h3><%=c.getCust_mobile() %></h3>
            </div>
            <div class="form-group">
                <label class="label-heading">Address:</label>
                <h3><%=c.getCust_address() %></h3>
            </div>
            <div class="form-group">
                <label class="label-heading">Guardian Name:</label>
                <h3><%=c.getCust_gname() %></h3>
            </div>
            <div class="form-group">
                <label class="label-heading">Nominee id:</label>
                <h3><%=n.getNom_id()%></h3>
            </div>
            <div class="form-group">
                <label class="label-heading">Nominee Name:</label>
                <h3><%=n.getLnap_nominee()%></h3>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label class="label-heading">Nominee Relation:</label>
                <h3><%=n.getLanp_relation()%></h3>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label class="label-heading">Loan Id:</label>
                <h3><%=l.getLnap_id()%></h3>
            </div>
            <div class="form-group">
                <label class="label-heading">Applied date:</label>
                <h3><%=l.getLnap_apdate()%></h3>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label class="label-heading">Loan Type:</label>
                <h3><%=l.getLnap_lnty_id()%></h3>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label class="label-heading">Amount:</label>
                <h3><%=l.getLnap_amount()%></h3>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label class="label-heading">EMI range from:</label>
                <h3><%=l.getLnap_emi_range_from()%></h3>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label class="label-heading">EMI range To:</label>
                <h3><%=l.getLnap_emi_range_to()%></h3>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label class="label-heading">Cibil score:</label>
                <h3><%=l.getLnap_cibil_Score()%></h3>
            </div>
        </div>
    </div>
    <input type="submit">
    <input type="hidden" name="loandetails"  value="l">
    <input type="hidden" name="customer"  value="c">
    <input type="hidden" name="nominee"  value="n">
    
</div>

</form>

<!-- Include Bootstrap JS and jQuery scripts -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>