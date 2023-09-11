package com.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Loan_Details")
public class LoanDetails {

	@Override
	public String toString() {
		return "LoanDetails [lnap_id=" + lnap_id + ", lnap_cust_id=" + lnap_cust_id + ", lnap_apdate=" + lnap_apdate
				+ ", lnap_lnty_id=" + lnap_lnty_id + ", lnap_amount=" + lnap_amount + ", lnap_emi_range_from="
				+ lnap_emi_range_from + ", lnap_emi_range_to=" + lnap_emi_range_to + ", lnap_nom_requested="
				+ lnap_nom_requested + ", lnap_cibil_Score=" + lnap_cibil_Score + ", lnap_status=" + lnap_status
				+ ", lnap_conclusion_remarks=" + lnap_conclusion_remarks + ", lnap_processed_user="
				+ lnap_processed_user + ", lnap_processed_Date=" + lnap_processed_Date + "]";
	}

	public LoanDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	

	public int getLnap_id() {
		return lnap_id;
	}

	public void setLnap_id(int lnap_id) {
		this.lnap_id = lnap_id;
	}

	public int getLnap_cust_id() {
		return lnap_cust_id;
	}

	public void setLnap_cust_id(int lnap_cust_id) {
		this.lnap_cust_id = lnap_cust_id;
	}

	public int getLnap_lnty_id() {
		return lnap_lnty_id;
	}

	public void setLnap_lnty_id(int lnap_lnty_id) {
		this.lnap_lnty_id = lnap_lnty_id;
	}

	public double getLnap_amount() {
		return lnap_amount;
	}

	public void setLnap_amount(double lnap_amount) {
		this.lnap_amount = lnap_amount;
	}

	public double getLnap_emi_range_from() {
		return lnap_emi_range_from;
	}

	public void setLnap_emi_range_from(double lnap_emi_range_from) {
		this.lnap_emi_range_from = lnap_emi_range_from;
	}

	public double getLnap_emi_range_to() {
		return lnap_emi_range_to;
	}

	public void setLnap_emi_range_to(double lnap_emi_range_to) {
		this.lnap_emi_range_to = lnap_emi_range_to;
	}

	public int getLnap_nom_requested() {
		return lnap_nom_requested;
	}

	public void setLnap_nom_requested(int lnap_nom_requested) {
		this.lnap_nom_requested = lnap_nom_requested;
	}

	public int getLnap_cibil_Score() {
		return lnap_cibil_Score;
	}

	public void setLnap_cibil_Score(int lnap_cibil_Score) {
		this.lnap_cibil_Score = lnap_cibil_Score;
	}

	public int getLnap_noy() {
		return lnap_noy;
	}

	public void setLnap_noy(int lnap_noy) {
		this.lnap_noy = lnap_noy;
	}

	public String getLnap_status() {
		return lnap_status;
	}

	public void setLnap_status(String lnap_status) {
		this.lnap_status = lnap_status;
	}

	public String getLnap_conclusion_remarks() {
		return lnap_conclusion_remarks;
	}

	public void setLnap_conclusion_remarks(String lnap_conclusion_remarks) {
		this.lnap_conclusion_remarks = lnap_conclusion_remarks;
	}

	public int getLnap_processed_user() {
		return lnap_processed_user;
	}

	public void setLnap_processed_user(int lnap_processed_user) {
		this.lnap_processed_user = lnap_processed_user;
	}

	public Date getLnap_apdate() {
		return lnap_apdate;
	}

	public Date getLnap_processed_Date() {
		return lnap_processed_Date;
	}





	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int lnap_id;

	int lnap_cust_id;
	Date lnap_apdate;
	int lnap_lnty_id;
	double lnap_amount;
	double lnap_emi_range_from;
	double lnap_emi_range_to;
	int lnap_nom_requested;
	int lnap_cibil_Score;
	int lnap_noy;
	String lnap_status;
	String lnap_conclusion_remarks;
	int lnap_processed_user;
	Date lnap_processed_Date;
	public void setLnap_apdate(String lnap_apdate) {
		String dateString = lnap_apdate;
		Date sqlDate = null;

		try {
			sqlDate = Date.valueOf(dateString);

		} catch (IllegalArgumentException e) {

		}
		this.lnap_apdate = sqlDate;
	}
	public void setLnap_processed_Date(String lnap_processed_Date) {
		String dateString = lnap_processed_Date;
		Date sqlDate = null;

		try {
			sqlDate = Date.valueOf(dateString);

		} catch (IllegalArgumentException e) {

		}
		this.lnap_processed_Date = sqlDate;
	}


}