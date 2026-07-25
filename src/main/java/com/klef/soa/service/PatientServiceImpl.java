package com.klef.soa.service;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Patient;
import com.klef.soa.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{
  
	//autowired is used to connect two manageable beans PatientServiceImpl,PatientRepository and maintained by Springioc
	@Autowired
	private PatientRepository repo;
	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return repo.save(patient);
	}

	@Override
	public List<Patient> displayAllPatients() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Patient updatePatient(Patient p) {
		// TODO Auto-generated method stub
        Optional<Patient> optional=repo.findById(p.getId());
        if(optional.isPresent())
        {
        	Patient patient =optional.get();
        	patient.setName(p.getName());
        	patient.setAge(p.getAge());
        	patient.setContact(p.getContact());
        	patient.setRemarks(p.getRemarks());
		return repo.save(patient);
        }
        else {
        	return null;
        }
	}

	@Override
	public List<Patient> displayPatientsByGender(String gender) {
		// TODO Auto-generated method stub
		
		return repo.findByGender(gender);
	}

	@Override
	public Patient displayPatientById(Long id) {
		// TODO Auto-generated method stub
		 return repo.findById(id).orElse(null); 
	}

	@Override
	public String deletePatientById(Long id) {
		// TODO Auto-generated method stub
		boolean status=repo.existsById(id);
		if(status) {
			repo.deleteById(id);
			return "succesfully deleted";
		}
		else {
			return "patient id not found";
		}
	}

}