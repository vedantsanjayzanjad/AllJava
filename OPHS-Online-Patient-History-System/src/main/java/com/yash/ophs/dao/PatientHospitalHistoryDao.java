package com.yash.ophs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.ophs.model.PatientHospitalHistory;

public interface PatientHospitalHistoryDao extends JpaRepository<PatientHospitalHistory, Integer> {

}
