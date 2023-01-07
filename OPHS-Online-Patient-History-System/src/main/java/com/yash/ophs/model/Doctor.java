package com.yash.ophs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dr_id")
	private int doctorId;

	@Column(name = "dr_name")
	private String doctorName;

	@Column(name = "dr_mob_name")
	private String doctorMobileNumber;

	@Column(name = "dr_age")
	private int doctorAge;

	@Column(name = "dr_gender")
	private String doctorGender;

	@Column(name = "dr_qualif")
	private String doctorQualification;

	@Column(name = "dr_specific")
	private String doctorSpecification;

	Doctor() {

	}

	public Doctor(int doctorId, String doctorName, String doctorMobileNumber, int doctorAge, String doctorGender,
			String doctorQualification, String doctorSpecification) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorMobileNumber = doctorMobileNumber;
		this.doctorAge = doctorAge;
		this.doctorGender = doctorGender;
		this.doctorQualification = doctorQualification;
		this.doctorSpecification = doctorSpecification;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorMobileNumber() {
		return doctorMobileNumber;
	}

	public void setDoctorMobileNumber(String doctorMobileNumber) {
		this.doctorMobileNumber = doctorMobileNumber;
	}

	public int getDoctorAge() {
		return doctorAge;
	}

	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}

	public String getDoctorGender() {
		return doctorGender;
	}

	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}

	public String getDoctorQualification() {
		return doctorQualification;
	}

	public void setDoctorQualification(String doctorQualification) {
		this.doctorQualification = doctorQualification;
	}

	public String getDoctorSpecification() {
		return doctorSpecification;
	}

	public void setDoctorSpecification(String doctorSpecification) {
		this.doctorSpecification = doctorSpecification;
	}

}
