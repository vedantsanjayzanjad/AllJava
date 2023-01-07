package com.yash.ophs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.ophs.model.PatientDocVisit;

public interface PatientDocVisitDao extends JpaRepository<PatientDocVisit, Integer> {

}
