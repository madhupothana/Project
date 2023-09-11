<!DOCTYPE html>
<html>

<head>
    <title>Loan Eligibility Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles.css"> <!-- Create a styles.css file for your custom styles -->

    <script>
        // Function to populate the "Number of Years" or "Number of Months" dropdown dynamically
        function populateNumberOfYearsOrMonthsDropdown(yearsOrMonths, isYears) {
            var numberOfYearsDropdown = document.getElementById("numberOfYears");

            // Clear existing options
            numberOfYearsDropdown.innerHTML = '';

            // Add options dynamically
            for (var i = 1; i <= yearsOrMonths; i++) {
                var option = document.createElement("option");
                option.value = i;
                option.text = isYears ? i + " Year" : i + " Month";
                numberOfYearsDropdown.appendChild(option);
            }
        }

        function calculateDisposableAmount() {
            var annualIncomeInput = document.getElementById("annualIncome");
            var disposableAmountDiv = document.getElementById("disposableAmount");

            var annualIncome = parseFloat(annualIncomeInput.value);

            var disposableAmount = annualIncome * 0.3;
            var loanLimit = annualIncome * 240;

            disposableAmountDiv.textContent = disposableAmount.toFixed(2);

            // Set the max attribute for the loanAmount input field
            document.getElementById("loanAmount").max = loanLimit;

            document.getElementById("loanAmountNote").textContent = "Note: Loan amount should not exceed Rs." + loanLimit;
        }

        function validateLoanAmount() {
            var loanAmountInput = document.getElementById("loanAmount");
            var loanLimit = parseFloat(loanAmountInput.max);
            var loanAmount = parseFloat(loanAmountInput.value);

            if (loanAmount > loanLimit) {
                alert("Loan amount exceeds the maximum limit of Rs." + loanLimit);
                loanAmountInput.value = "";
                populateNumberOfYearsOrMonthsDropdown(10, true); // Default to years
            }
        }


        function setYears() {
            var loanAmtInput = document.getElementById("loanAmount");
            var loanAmt = parseFloat(loanAmtInput.value);

            var annualIncomeInput = document.getElementById("annualIncome");
            var annualIncome = parseFloat(annualIncomeInput.value);

            var disposableAmount = annualIncome * 0.3;
            var years = parseInt(loanAmt / (disposableAmount * 12));
            var months = parseInt(loanAmt / disposableAmount);

            console.log("years and months..." + years + " " + months);

            if (years > 0 && months % 12 != 0)
                years = years + 1;

            console.log("modified years and months..." + years + " " + months);
            if (years > 0) {
                populateNumberOfYearsOrMonthsDropdown(years, true);
                console.log("entered here years"); // Generate years dropdown
            } else {
                populateNumberOfYearsOrMonthsDropdown(months, false);
                console.log("entered here months"); // Generate months dropdown
            }
        }

        function calculateEMI() {
            var loanAmtInput = document.getElementById("loanAmount");
            var loanAmt = parseFloat(loanAmtInput.value);

            var numberOfYearsInput = document.getElementById("numberOfYears");
            var numberOfYears = parseFloat(numberOfYearsInput.value);

            var annualIncomeInput = document.getElementById("annualIncome");
            var annualIncome = parseFloat(annualIncomeInput.value);

            var disposableAmount = annualIncome * 0.3;
            var years = parseInt(loanAmt / (disposableAmount * 12));

            var emiRangeDiv = document.getElementById("emiRange");

            if (years > 0) {
                var months = numberOfYears * 12;
                document.getElementById("months").value = months;
                var emiAmount = (loanAmt / months).toFixed(2);
                document.getElementById("emiAmt").value = emiAmount;
                emiRangeDiv.textContent = "Rs. " + emiAmount + " per month for " + numberOfYears + " years";
            } else {
                var emiAmount = (loanAmt / numberOfYears).toFixed(2);
                document.getElementById("months").value = numberOfYears;
                document.getElementById("emiAmt").value = emiAmount.toFixed(2);
                emiRangeDiv.textContent = "Rs. " + emiAmount + " per month for " + numberOfYears + " months";
            }
        }

        window.onload = function () {
            var maxYears = 10;
            populateNumberOfYearsOrMonthsDropdown(maxYears, true); // Default to years
        }
    </script>
</head>

<body>
    <center>
    <div class="header bg-dark text-white py-3">
		<h1 class="text-center">MSB Bank</h1>
	</div>
        <h1>Loan Eligibility Form</h1>
        <form action="afterEmi" method="get">
            <div class="container">
                <div class="form-group">
                    <label for="annualIncome">Annual Income:</label>
                    <input type="text" class="form-control" id="annualIncome" name="annualIncome" required
                        onchange="calculateDisposableAmount()">
                </div>
                <div class="form-group">
                    <label>Disposable Amount:</label>
                    <div id="disposableAmount" name="disposableAmount"></div>
                </div>
                <div class="form-group">
                    <div id="loanAmountNote" name="loanAmountNote"></div>
                </div>
                <div class="form-group">
                    <label for="loanAmount">Loan Amount:</label>
                    <input type="number" class="form-control" id="loanAmount" name="loanAmount"
                        onblur="validateLoanAmount()" onchange="setYears()" required>
                </div>
                <div class="form-group">
                    <label for="numberOfYears">Number of Years/Months:</label>
                    <select class="form-control" id="numberOfYears" name="numberOfYears" onchange="calculateEMI()"
                        required>
                        <!-- Options will be populated dynamically via JavaScript -->
                    </select>
                </div>
                <div class="form-group">
                    <label>EMI Range:</label>
                    <div id="emiRange" name="emiRange"></div>
                </div>
            </div>
            <input type="hidden" id="emiAmt" name="emiAmount">
            <input type="hidden" id="months" name="months">
            <div class="text-center">
                <input type="submit" class="btn btn-primary" value="Submit">
            </div>
        </form>
    </center>
</body>

</html>
