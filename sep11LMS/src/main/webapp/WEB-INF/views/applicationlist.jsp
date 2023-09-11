<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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

    <div class="container">
        <h1>Loan Applicant List</h1>

        <form id="filterForm">
            <div class="form-row">
                <div class="col-md-4 mb-3">
                    <label for="minLoanAmount">Min Loan Amount:</label> <input
                        type="text" class="form-control" id="minLoanAmount"
                        name="minLoanAmount">
                </div>
                <div class="col-md-4 mb-3">
                    <label for="maxLoanAmount">Max Loan Amount:</label> <input
                        type="text" class="form-control" id="maxLoanAmount"
                        name="maxLoanAmount">
                </div>
                <div class="col-md-4 mb-3">
                    <label for="status">Status:</label> <select class="form-control"
                        id="status" name="status">
                        <option value="">All</option>
                        <option value="Approved">Approved</option>
                        <option value="Pending">Pending</option>
                        <option value="Rejected">Rejected</option>
                    </select>
                </div>
                <div class="col-md-4 mb-3">
                    <button type="submit" class="btn btn-primary">Apply Filter</button>
                </div>
            </div>
        </form>
        
        <form action="downloadexcel" method="post" id="downloadExcelForm">
            <input type="hidden" id="selectedLnapIds" name="selectedLnapIds" value="">
            <input type="submit" value="Download Excel">
        </form>

        <!-- Table -->
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>App_id</th>
                    <th>Cus_id</th>
                    <th>App_date</th>
                    <th>LOan_type</th>
                    <th>No Of Years</th>
                    <th>Loan amount</th>
                    <th>Emi from</th>
                    <th>Emi To</th>
                    <th>Nominee</th>
                    <th>Cibil Score</th>
                    <th>Status</th>
                    <th>Admin User</th>
                    <th>Last Updated Date</th>
                    <th>View</th>
                </tr>
            </thead>
            <tbody>
                <%
                ArrayList<LoanDetails> Applist = (ArrayList<LoanDetails>) request.getAttribute("llist");
                for (LoanDetails e : Applist) {
                %>

                <tr>
                    <td><%=e.getLnap_id()%></td>
                    <input type=>
                    <td><%=e.getLnap_cust_id()%></td>
                    <td><%=e.getLnap_apdate()%></td>
                    <td><%=e.getLnap_lnty_id()%></td>
                    <td><%=e.getLnap_noy()%></td>
                    <td><%=e.getLnap_amount()%></td>
                    <td><%=e.getLnap_emi_range_from()%></td>
                    <td><%=e.getLnap_emi_range_to()%></td>
                    <td><%=e.getLnap_nom_requested()%></td>
                    <td><%=e.getLnap_cibil_Score()%></td>
                    <td><%=e.getLnap_status()%></td>
                    <td><%=e.getLnap_processed_user()%></td>
                    <td><%=e.getLnap_processed_Date()%></td>
                    <td>
                        <form action="view" method="post">
                            <input type="hidden" name="id" value="<%=e.getLnap_id()%>">
                            <input type="submit" value="VIEW">
                        </form>
                    </td>
                </tr>

                <%
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
    <script>
        $(document).ready(function () {
            // Handle the "Apply Filter" button click event
            $("#filterForm").submit(function (event) {
                event.preventDefault();
                filterTable();
            });

            // Handle the "Download Excel" button click event
            $("#downloadExcelForm").submit(function (event) {
                event.preventDefault();
                downloadExcel();
            });

            // Function to gather and update the selected lnapid values
            function updateSelectedLnapIds() {
                var selectedLnapIds = [];

                $("tbody tr:visible").each(function () {
                    var lnapId = $(this).find("td:first-child").text();
                    selectedLnapIds.push(lnapId);
                });

                $("#selectedLnapIds").val(selectedLnapIds.join(","));
            }

            // Function to trigger the download of Excel
            function downloadExcel() {
                updateSelectedLnapIds();
                $("#downloadExcelForm")[0].submit();
            }

            // Function to filter the table
            function filterTable() {
                var minLoanAmount = parseFloat($("#minLoanAmount").val());
                var maxLoanAmount = parseFloat($("#maxLoanAmount").val());
                var selectedStatus = $("#status").val();

                $("tbody tr").each(function () {
                    var row = $(this);
                    var rowLoanAmount = parseFloat(row.find("td:nth-child(6)").text());
                    var rowStatus = row.find("td:nth-child(11)").text();

                    // Check if the row's loan amount is within the specified range and matches the selected status
                    if ((!isNaN(minLoanAmount) && rowLoanAmount >= minLoanAmount)
                            && (!isNaN(maxLoanAmount) && rowLoanAmount <= maxLoanAmount)
                            && (selectedStatus === "" || rowStatus === selectedStatus)) {
                        row.show();
                    } else {
                        row.hide();
                    }
                });
            }
        });
    </script>
</body>
</html>