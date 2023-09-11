package com.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cmbs_customers")
public class Customer {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int cust_id;

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_firstname=" + cust_firstname + ", cust_lastname="
				+ cust_lastname + ", cust_dob=" + cust_dob + ", cust_panno=" + cust_panno + ", cust_mobile="
				+ cust_mobile + ", cust_address=" + cust_address + ", cust_gname=" + cust_gname + "]";
	}

	private String cust_firstname, cust_lastname;
	private Date cust_dob;
	private String cust_panno;
	private String cust_mobile, cust_address, cust_gname;

	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getCust_firstname() {
		return cust_firstname;
	}

	public String getCust_lastname() {
		return cust_lastname;
	}

	public Date getCust_dob() {
		return cust_dob;
	}

	public String getCust_panno() {
		return cust_panno;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public String getCust_address() {
		return cust_address;
	}

	public String getCust_gname() {
		return cust_gname;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public void setCust_firstname(String cust_firstname) {
		this.cust_firstname = cust_firstname;
	}

	public void setCust_lastname(String cust_lastname) {
		this.cust_lastname = cust_lastname;
	}

	public void setCust_dob(String cust_dob) {
		String dateString = cust_dob;
		Date sqlDate = null;

		try {
			sqlDate = Date.valueOf(dateString);

		} catch (IllegalArgumentException e) {

		}
		this.cust_dob = sqlDate;
	}

	public void setCust_panno(String cust_panno) {
		this.cust_panno = cust_panno;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public void setCust_gname(String cust_gname) {
		this.cust_gname = cust_gname;
	}

	public Customer(int cust_id, String cust_firstname, String cust_lastname, Date cust_dob, String cust_panno,
			String cust_mobile, String cust_address, String cust_gname) {
		super();

		this.cust_id = cust_id;
		this.cust_firstname = cust_firstname;
		this.cust_lastname = cust_lastname;
		this.cust_dob = cust_dob;
		this.cust_panno = cust_panno;
		this.cust_mobile = cust_mobile;
		this.cust_address = cust_address;
		this.cust_gname = cust_gname;
	}

	public int getCust_id() {
		return cust_id;
	}

}