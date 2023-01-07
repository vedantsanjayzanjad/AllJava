package com.yash.ophs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.ophs.model.PatientDiseaseHistory;

public interface PatientDiseaseHistoryDao extends JpaRepository<PatientDiseaseHistory,Integer> {

}
