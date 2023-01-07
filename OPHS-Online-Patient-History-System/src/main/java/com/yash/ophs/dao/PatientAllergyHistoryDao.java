package com.yash.ophs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.ophs.model.PatientAllergyHistory;

public interface PatientAllergyHistoryDao extends JpaRepository<PatientAllergyHistory , Integer> {

}
