package com.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LoanApplicantDao;
import com.model.LoanDetails;



public class LoanApplicantService {
	
	private LoanApplicantDao lad;
	
	@Autowired
	LoanApplicantService(LoanApplicantDao lad){
		this.lad=lad;
	}

	@Transactional
	public void add(LoanDetails emp) {
		System.out.println(2);
		lad.persistApplicant(emp);
	
	}

	public ArrayList<LoanDetails> getAll() {
		// TODO Auto-generated method stub
		return lad.findAll();
		
	}
	public LoanDetails getApplicant(int id) {
		// TODO Auto-generated method stub
		return lad.getApplicant(id);
	}

	public void editApplicant(LoanDetails la) {
		// TODO Auto-generated method stub
		lad.editApplicant(la);
	}
}