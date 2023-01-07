package com.yash.ophs.service;

import java.util.List;
import java.util.Optional;

import com.yash.ophs.model.Medicine;

public interface MedicineService {
	public List<Medicine> getAllMedicines();

	public Optional<Medicine> getOneMedicine(int tabletId);

	public Medicine addMedicine(Medicine medicine);

	public Medicine update(Medicine medicine, int tabletId);

	public void deleteMedicine(int tabletId);
}
