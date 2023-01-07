package com.yash.ophs.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ophs.dao.MedicineDao;
import com.yash.ophs.model.Medicine;
import com.yash.ophs.service.MedicineService;

@Service
public class MedicineServiceImplementation implements MedicineService {

	@Autowired
	private MedicineDao medicineDao;

	@Override
	public List<Medicine> getAllMedicines() {
		// TODO Auto-generated method stub
		return medicineDao.findAll();
	}

	@Override
	public Optional<Medicine> getOneMedicine(int tabletId) {
		// TODO Auto-generated method stub
		return medicineDao.findById(tabletId);
	}

	@Override
	public Medicine addMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		medicineDao.save(medicine);
		return medicine;
	}

	@Override
	public Medicine update(Medicine medicine, int tabletId) {
		// TODO Auto-generated method stub
		
		Optional<Medicine > op= medicineDao.findById(tabletId);
		if(op.isPresent())
		{
			Medicine  med  =op.get();
			med.setTabletName(medicine.getTabletName());
			med.setTabletPrice(medicine.getTabletPrice());
			med.setTabletQuantity(medicine.getTabletQuantity());
			med.setPrice(medicine.getPrice());
			medicineDao.save(med);
			System.out.println("Medicine update successfully");
		}		
		else
		{
			System.out.println("product not found");
		}
		return medicine;
	}

	@Override
	public void deleteMedicine(int tabletId) {
		// TODO Auto-generated method stub
		medicineDao.deleteById(tabletId);
	}

}
