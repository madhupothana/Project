package com.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;
import com.model.LoanDetails;

public class LoanApplicantDao {
	@PersistenceContext
	private EntityManager em;

	public void persistApplicant(LoanDetails cus) {
		System.out.println(3);
		em.persist(cus);

	}

	public ArrayList<LoanDetails> findAll() {
		// TODO Auto-generated method stub
		return (ArrayList<LoanDetails>) em.createQuery("select l from LoanDetails l").getResultList();
	}

	public LoanDetails getApplicant(int id) {
		String jpql = "SELECT e FROM LoanDetails e WHERE e.id = :paramValue";
		Query query = em.createQuery(jpql);
		query.setParameter("paramValue", id);
		return (LoanDetails) query.getSingleResult();
	}
	@Transactional
	public void editApplicant(LoanDetails updatedApplicant) {
	    // Step 1: Load the Entity by ID
	    LoanDetails existingApplicant = em.find(LoanDetails.class, updatedApplicant.getLnap_id());

	    if (existingApplicant != null) {
	        // Step 2: Modify the Entity
	        existingApplicant.setLnap_noy(updatedApplicant.getLnap_noy());
	        existingApplicant.setLnap_status(updatedApplicant.getLnap_status());

	        // The changes will be automatically flushed and updated in the database upon transaction completion.
	    } 
	}

}