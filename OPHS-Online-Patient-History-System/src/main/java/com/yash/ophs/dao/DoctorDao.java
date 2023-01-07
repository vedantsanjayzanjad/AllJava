package com.yash.ophs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ophs.model.Doctor;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer>
{

}
