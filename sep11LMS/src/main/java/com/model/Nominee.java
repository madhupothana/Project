package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cmbs_nominee")
public class Nominee {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int nom_id;
	String lnap_nominee, lanp_relation;
	 

	
	
	@Override
	public String toString() {
		return "Nominee [nom_id=" + nom_id + ", lnap_nominee=" + lnap_nominee + ", lanp_relation=" + lanp_relation
				+ "]";
	}

	public Nominee(int nom_id, String lnap_nominee, String lanp_relation) {
		super();
		this.nom_id = nom_id;
		this.lnap_nominee = lnap_nominee;
		this.lanp_relation = lanp_relation;
	}

	public Nominee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNom_id() {
		return nom_id;
	}

	public String getLnap_nominee() {
		return lnap_nominee;
	}

	public String getLanp_relation() {
		return lanp_relation;
	}

	public void setNom_id(int nom_id) {
		this.nom_id = nom_id;
	}

	public void setLnap_nominee(String lnap_nominee) {
		this.lnap_nominee = lnap_nominee;
	}

	public void setLanp_relation(String lanp_relation) {
		this.lanp_relation = lanp_relation;
	}

}