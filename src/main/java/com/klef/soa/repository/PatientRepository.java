package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>
{
	
}
