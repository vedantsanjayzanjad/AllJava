package com.yash.ophs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.ophs.model.Medicine;

public interface MedicineDao extends JpaRepository<Medicine, Integer>{

}
