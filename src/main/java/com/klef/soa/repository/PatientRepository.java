package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Patient;
import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>
{
	//from Patient p where p.gender=?1
	List<Patient> findByGender(String gender);
}
