package com.yash.ophs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientDiseaseHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int pdhId;
	
	@Column(name = "sev_of_disease")
	private String seviretyOfDisease;
}
