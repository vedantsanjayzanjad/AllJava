package com.yash.ophs.service;

import java.util.List;
import java.util.Optional;

import com.yash.ophs.model.PatientDocVisit;

public interface PatientDocVisitService {
	public List<PatientDocVisit> getAllPatientDocVisits();

	public Optional<PatientDocVisit> getOnePatientDocVisit(int pdvId);

	public PatientDocVisit addPatientDocVisit(PatientDocVisit patientDocVisit);

	public PatientDocVisit update(PatientDocVisit patientDocVisit, int pdvId);

	public void deletePatientDocVisit(int pdvId);
}
