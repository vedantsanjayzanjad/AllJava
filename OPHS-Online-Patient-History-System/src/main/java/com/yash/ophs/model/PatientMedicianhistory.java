package com.yash.ophs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientMedicianhistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pmhId;
	private String dose;
}
