package com.yash.ophs.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ophs.dao.PatientDocVisitDao;
import com.yash.ophs.model.PatientDocVisit;
import com.yash.ophs.model.RoomType;
import com.yash.ophs.service.PatientDocVisitService;

@Service
public class PatientDocVisitServiceImplementation implements PatientDocVisitService {

	
	@Autowired
	private PatientDocVisitDao patDocVisDao;
	@Override
	public List<PatientDocVisit> getAllPatientDocVisits() {
		// TODO Auto-generated method stub
		return patDocVisDao.findAll() ;
	}

	@Override
	public Optional<PatientDocVisit> getOnePatientDocVisit(int pdvId) {
		// TODO Auto-generated method stub
		return patDocVisDao.findById(pdvId);
	}

	@Override
	public PatientDocVisit addPatientDocVisit(PatientDocVisit patientDocVisit) {
		// TODO Auto-generated method stub
		 patDocVisDao.save(patientDocVisit);
		return patientDocVisit;
	}

	@Override
	public PatientDocVisit update(PatientDocVisit patientDocVisit, int pdvId) {
		// TODO Auto-generated method stub
		Optional<PatientDocVisit> op= patDocVisDao.findById(pdvId);
		if(op.isPresent())
		{
			PatientDocVisit patDocVis  =op.get();
			patDocVis.setVisitDate(patientDocVisit.getVisitDate());
			patDocVis.setNextVisitDate(patientDocVisit.getNextVisitDate());
			patDocVisDao.save(patDocVis);
			System.out.println("PatientDocVisit Successfully update successfully");
		}		
		else
		{
			System.out.println("PatientDocVisit not found");
		}
		return patientDocVisit;
	}
	

	@Override
	public void deletePatientDocVisit(int pdvId) {
		// TODO Auto-generated method stub
		patDocVisDao.deleteById(pdvId);
	}

}
