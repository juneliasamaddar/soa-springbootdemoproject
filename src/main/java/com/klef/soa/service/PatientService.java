package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Patient;

public interface PatientService 
{
	Patient addPatient(Patient patient);
	List<Patient> displayAllPatients();
	Patient updatePatient(Patient p);
}
