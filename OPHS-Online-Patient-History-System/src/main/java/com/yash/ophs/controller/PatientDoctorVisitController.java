package com.yash.ophs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ophs.model.Doctor;
import com.yash.ophs.model.PatientDocVisit;
import com.yash.ophs.serviceimplementation.PatientDocVisitServiceImplementation;

@RestController
@RequestMapping("/patientDocVis")
public class PatientDoctorVisitController {
	
	@Autowired
	private PatientDocVisitServiceImplementation patDocvisImpl;
	
	@GetMapping("/getAllPatientDocVis")
	public List<PatientDocVisit> getAllPatientDocVisits() {

		return this.patDocvisImpl.getAllPatientDocVisits();
	}

	@GetMapping("/getOnePatientDocVis/{pdvId}")
	public Optional<PatientDocVisit> getOnePatientDoctorVisitById(@PathVariable String pdvId) {

		return patDocvisImpl.getOnePatientDocVisit(Integer.parseInt(pdvId));
	}

	@PostMapping("/addPatientDocVis")
	public PatientDocVisit addDoctor(@RequestBody PatientDocVisit patDocV) {
		return this.patDocvisImpl.addPatientDocVisit(patDocV);

	}

	@PutMapping("/updatePatientDocVis/{pdvId}")
	public PatientDocVisit updatePatientDoctorVisit(@RequestBody PatientDocVisit patDocV, @PathVariable int pdvId) {
		return this.patDocvisImpl.update(patDocV,pdvId);

	}

	@DeleteMapping("/deletePatientDocVis/{pdvId}")
	public void deletePatientDoctorVisit(@PathVariable String pdvId) {
		patDocvisImpl.deletePatientDocVisit(Integer.parseInt(pdvId));
	}

}
