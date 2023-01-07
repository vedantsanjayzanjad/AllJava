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
import com.yash.ophs.service.DoctorService;
 


@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService drSerImpl;

	@GetMapping("/getAllDoctor")
	public List<Doctor> getAllDoctors() {

		return this.drSerImpl.getAllDoctors();
	}

	@GetMapping("/getOneDoctor/{doctorId}")
	public Optional<Doctor> getDoctorById(@PathVariable String doctorId) {

		return drSerImpl.getOneDoctor(Integer.parseInt(doctorId));
	}

	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return this.drSerImpl.addDoctor(doctor);

	}

	@PutMapping("/updateDoctor/{doctorId}")
	public Doctor update(@RequestBody Doctor doctor, @PathVariable int doctorId) {
		return this.drSerImpl.update(doctor,doctorId);

	}

	@DeleteMapping("/deleteDoctor/{doctorId}")
	public void deleteDoctor(@PathVariable String doctorId) {
		drSerImpl.deleteDoctor(Integer.parseInt(doctorId));
	}
}
