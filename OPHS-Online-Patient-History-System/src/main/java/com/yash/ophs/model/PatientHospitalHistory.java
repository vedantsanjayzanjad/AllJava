package com.yash.ophs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientHospitalHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int phhId;
	
	@Column(name ="adm_date")
	private String admitDate;
	private String dischargedate;
	private double bill;
}
