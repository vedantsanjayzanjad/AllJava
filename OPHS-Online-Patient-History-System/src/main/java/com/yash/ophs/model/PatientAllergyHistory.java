package com.yash.ophs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientAllergyHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pahId;
	
}
