package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Customer;

import com.model.LoanDetails;
import com.model.Nominee;
import com.services.CustomerService;
import com.services.LoanApplicantService;

@Controller
public class LmsCustomerController {
	LoanApplicantService las;

	@Autowired
	public LmsCustomerController(LoanApplicantService las, CustomerService customerservice) {
		this.las = las;
		this.customerservice = customerservice;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {

		return "admin";
	}

	@RequestMapping(value = "/customerlogin", method = RequestMethod.GET)
	public String customerlogin() {

		return "customerlogin";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {

		return "about";
	}
	@RequestMapping(value = "/proceed", method = RequestMethod.GET)
	public String proceed(Model model,@RequestParam("amount") double a,@RequestParam("cibil") double cibil) {
		model.addAttribute("amount", a);
		model.addAttribute("cibil", cibil);
		return "proceed";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String start() {
		return "customeroptions";
	}
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String check() {
		return "check";
	}

	@RequestMapping(value = "/listall")
	public String list() {
		return "applicationlist";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String Applicant() {

		return "adminoptions";
	}

	@RequestMapping(value = "/listApplicants", method = RequestMethod.GET)
	public String listApplicants(Model model) {
		ArrayList<LoanDetails> llist = las.getAll();
		model.addAttribute("llist", llist);
		return "applicationlist";
	}

	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public String View(@RequestParam("id") int id, Model model) {
		
		LoanDetails l = las.getApplicant(id);
		model.addAttribute("applicant", l);
		return "view";
	}

	@RequestMapping(value = "/Editapplicant", method = RequestMethod.POST)
	public String View(LoanDetails la, Model model) {
		System.out.println(la);
		las.editApplicant(la);
		ArrayList<LoanDetails> llist = las.getAll();
		model.addAttribute("llist", llist);
		return "applicationlist";
	}

	CustomerService customerservice;

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String loanApplicant(HttpSession session, Model model, Customer customer, Nominee nominee,
			LoanDetails loandetails) {
		
		model.addAttribute("customer", customer);
		model.addAttribute("nominee", nominee);
		model.addAttribute("loandetails", loandetails);
		session.setAttribute("customer", customer);
		session.setAttribute("nominee", nominee);
		session.setAttribute("loandetails", loandetails);
		return "preview";

	}

	@RequestMapping(value = "/newapplication", method = RequestMethod.GET)
	public String preview() {

		return "customer";
	}
	
	//loanAmount=1000000000&numberOfYears=2&emiAmount=41666666.67&months=24
	
	@RequestMapping(value = "/afterEmi", method = RequestMethod.GET)
	public String afterEligibilty(Model model,@RequestParam("emiAmount")double EmiAmount,@RequestParam("months")int span,@RequestParam("loanAmount")double loanAmount) {
		model.addAttribute("EmiAmount", EmiAmount);
		model.addAttribute("months", span);
		model.addAttribute("LoanAmount",loanAmount);
		return "AfterEligible";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		Nominee nominee = (Nominee) session.getAttribute("nominee");
		LoanDetails loandetails = (LoanDetails) session.getAttribute("loandetails");

		customerservice.addCustomer(customer);

		customerservice.addNominee(nominee);
		loandetails.setLnap_cust_id(customer.getCust_id());
		loandetails.setLnap_nom_requested(nominee.getNom_id());
		customerservice.addLoan(loandetails);
		session.removeAttribute("customer");
		session.removeAttribute("nominee");
		session.removeAttribute("loandetails");
		return "save";
	}

	@RequestMapping(value = "/downloadexcel", method = RequestMethod.POST)
	public void downloadExcel(@RequestParam("selectedLnapIds") String selectedLnapIds, HttpServletResponse response) throws IOException {
	    // Convert the comma-separated string to an array or list of selected lnapid values
	    String[] lnapIdArray = selectedLnapIds.split(",");
		System.out.println("lllllllllllllllllldhdh");
		System.out.println(lnapIdArray.length);
		ArrayList<LoanDetails> Loans=new ArrayList<>();
		for(int i=0;i<lnapIdArray.length;i++) {
			Loans.add(las.getApplicant(Integer.parseInt(lnapIdArray[i])));
		}
		

		// Create an Excel workbook using Apache POI
		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Employee Data");
		Row headerRow = sheet.createRow(0);

	    // Define column headings
	    headerRow.createCell(0).setCellValue("Loan_Id");
	    headerRow.createCell(1).setCellValue("Customer_Id");
	    headerRow.createCell(2).setCellValue("Loan_Applied_Date");
	    headerRow.createCell(3).setCellValue("Loan_Type_Id");
	    headerRow.createCell(4).setCellValue("Amount");
	    headerRow.createCell(5).setCellValue("Emi_Range_From");
	    headerRow.createCell(6).setCellValue("Emi_Range_To");
	    headerRow.createCell(7).setCellValue("No_Years");
	    headerRow.createCell(8).setCellValue("Nominee_Id");
	    headerRow.createCell(9).setCellValue("Cibil_Score");
	    headerRow.createCell(10).setCellValue("Status");
	    headerRow.createCell(11).setCellValue("Remarks");
	    headerRow.createCell(12).setCellValue("Processed_User");
	    headerRow.createCell(13).setCellValue("Processed_Date");
	    
		// Populate the Excel sheet with data from the ArrayList
		int rowIdx = 1;
		for (LoanDetails loan : Loans) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(loan.getLnap_id());
			row.createCell(1).setCellValue(loan.getLnap_cust_id());
			row.createCell(2).setCellValue(loan.getLnap_apdate());
			row.createCell(3).setCellValue(loan.getLnap_lnty_id());
			row.createCell(4).setCellValue(loan.getLnap_amount());
			row.createCell(5).setCellValue(loan.getLnap_emi_range_from());
			row.createCell(6).setCellValue(loan.getLnap_emi_range_to());
			row.createCell(7).setCellValue(loan.getLnap_noy());
			row.createCell(8).setCellValue(loan.getLnap_nom_requested());
			row.createCell(9).setCellValue(loan.getLnap_cibil_Score());
			row.createCell(10).setCellValue(loan.getLnap_status());
			row.createCell(11).setCellValue(loan.getLnap_conclusion_remarks());
			row.createCell(12).setCellValue(loan.getLnap_processed_user());
			row.createCell(13).setCellValue(loan.getLnap_processed_Date());
		}

		// Set the response headers for Excel download
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=employees.xlsx");
		
		// Write the Excel data to the response output stream
		OutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.close();
	}

}