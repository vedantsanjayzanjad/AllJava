package com.yash.ophs.service;

import java.util.List;
import java.util.Optional;
import com.yash.ophs.model.Doctor;

public interface DoctorService {

	public List<Doctor> getAllDoctors();

	public Optional<Doctor> getOneDoctor(int doctorId);

	public Doctor addDoctor(Doctor doctor);

	public Doctor update(Doctor doctor, int doctorId);

	public void deleteDoctor(int doctorId);

}
