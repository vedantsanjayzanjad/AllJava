package com.yash.ophs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class PatientDocVisit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pdvId;
	private String visitDate;
	
	@Column(name = "nxt_vis_date")
	private String nextVisitDate;
	
	PatientDocVisit()
	{
		
	}

	public PatientDocVisit(int pdvId, String visitDate, String nextVisitDate) {
		super();
		this.pdvId = pdvId;
		this.visitDate = visitDate;
		this.nextVisitDate = nextVisitDate;
	}

	public int getPdvId() {
		return pdvId;
	}

	public void setPdvId(int pdvId) {
		this.pdvId = pdvId;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(String nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}
	
	
	
	
}
