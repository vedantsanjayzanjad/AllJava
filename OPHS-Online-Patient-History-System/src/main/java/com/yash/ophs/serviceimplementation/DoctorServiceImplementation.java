package com.yash.ophs.serviceimplementation;

import java.util.List;


import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.ophs.dao.DoctorDao;
import com.yash.ophs.model.Doctor;
import com.yash.ophs.service.DoctorService;

@Service
public class DoctorServiceImplementation implements DoctorService {

	private static final Logger log = Logger.getLogger(DoctorServiceImplementation.class);
	@Autowired
	private DoctorDao doctorDao;

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		log.info("Function GetAllDoctors :: Started");
		try
		{
		return doctorDao.findAll();
		}
		catch(Exception e)
		{
			log.error("Error In Function  GetAllDoctors :: "+e.getStackTrace() );
			return null;
		}
	}

	@Override
	public Optional<Doctor> getOneDoctor(int doctorId) {
		// TODO Auto-generated method stub
		log.info("Function getOneDoctor :: Started");
		try
		{
			return doctorDao.findById(doctorId);
		}
		catch(Exception e)
		{
			log.error("Error In Function  getOneDoctor :: "+e.getStackTrace() );
			return null;
		}
		
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		log.info("Function getOneDoctor :: Started");
		try
		{
			doctorDao.save(doctor);
			return  doctor;
		}
		catch(Exception e)
		{
			log.error("Error In Function getOneDoctor :: "+e.getStackTrace() );
			return null;
		}
		
	}

	@Override
	public Doctor update(Doctor doctor, int doctorId) {
		// TODO Auto-generated method stub
		log.info("Function updateDoctor :: Started");
		try
		{
			Optional<Doctor> op= doctorDao.findById(doctorId);
			if(op.isPresent())
			{
				Doctor dr =op.get();
				dr.setDoctorAge(doctor.getDoctorAge());
				dr.setDoctorGender(doctor.getDoctorGender());
				dr.setDoctorMobileNumber(doctor.getDoctorMobileNumber());
				dr.setDoctorName(doctor.getDoctorName());
				dr.setDoctorQualification(doctor.getDoctorQualification());
				dr.setDoctorSpecification(doctor.getDoctorSpecification());
				doctorDao.save(dr);
				System.out.println("Doctor update successfully");

			}		
			else
			{
				System.out.println("Doctor not found");
			}
		}
		catch(Exception e)
		{
			log.error("Error In Function  updateDoctor :: "+e.getStackTrace() );
			return null;
		}		
		return doctor;
	}

	@Override
	public void deleteDoctor(int doctorId) {
		// TODO Auto-generated method stub
		log.info("Function deleteDoctor :: Started");
		try
		{
			doctorDao.deleteById(doctorId);
		}
		catch(Exception e)
		{
			log.error("Error In Function  deleteDoctor :: "+e.getStackTrace() );
		}	
	}
}
