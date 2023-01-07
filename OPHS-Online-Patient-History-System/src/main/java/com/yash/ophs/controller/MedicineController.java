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

import com.yash.ophs.model.Medicine;
import com.yash.ophs.serviceimplementation.MedicineServiceImplementation;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
	private MedicineServiceImplementation medSercImpl;
	
	@GetMapping("/getAllMedicines")
	public List<Medicine> getAllDoctors() {

		return this.medSercImpl.getAllMedicines();
	}

	@GetMapping("/getOneMedicine/{tabletId}")
	public Optional<Medicine> getDoctorById(@PathVariable String tabletId) {

		return medSercImpl.getOneMedicine(Integer.parseInt(tabletId));
	}

	@PostMapping("/addMedicine")
	public Medicine addDoctor(@RequestBody Medicine medicine) {
		return this.medSercImpl.addMedicine(medicine);

	}

	@PutMapping("/updateMedicine/{tabletId}")
	public Medicine update(@RequestBody Medicine medicine, @PathVariable int tabletId) {
		return this.medSercImpl.update(medicine,tabletId);

	}

	@DeleteMapping("/deleteMedicine/{tabletId}")
	public void deleteMedicine(@PathVariable String tabletId) {
		medSercImpl.deleteMedicine(Integer.parseInt(tabletId));
	}
}
