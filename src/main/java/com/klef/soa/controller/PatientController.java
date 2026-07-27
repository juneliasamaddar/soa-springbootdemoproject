package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Patient;
import com.klef.soa.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController
{
	@Autowired
	private PatientService service;

	@GetMapping("/")
	public String test()
	{
		return "SOA Programming & MicroServices";
	}

	// Add Patient
	@PostMapping("/add") 
	public ResponseEntity<Patient> addpatient(@RequestBody Patient p) 
	{ 
		Patient patient = service.addPatient(p); 
		return ResponseEntity.status(201).body(patient); 
	}

	// Display All Patients
	@GetMapping("/displayall")
	public ResponseEntity<List<Patient>> displayAllPatients()
	{
		List<Patient> patients = service.displayAllPatients(); 
		return ResponseEntity.status(200).body(patients);
	}

	// Display Patient By ID
	@GetMapping("/display")
	public ResponseEntity<?> displayPatientById(@RequestParam Long id)
	{
		Patient patient = service.displayPatientById(id);

		if(patient != null)
		{
			return ResponseEntity.status(200).body(patient);
		}
		else
		{
			return ResponseEntity.status(404).body("Patient ID Not Found");
		}
	}

	// Update Patient
	@PutMapping("/update")
	public ResponseEntity<?> updatePatient(@RequestBody Patient patient)
	{
		Patient p = service.updatePatient(patient);

		if(p != null)
		{
			return ResponseEntity.ok(p);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient ID Not Found");
		}
	}

	// Delete Patient By ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePatientById(@PathVariable Long id)
	{
		String message = service.deletePatientById(id);

        return new ResponseEntity<>(message, HttpStatus.OK);
		
	}

	// Display Patients By Gender
	@GetMapping("/displaybygender/{gender}")
	public ResponseEntity<List<Patient>> displayPatientsByGender(@PathVariable String gender)
	{
		List<Patient> patients = service.displayPatientsByGender(gender);
		return ResponseEntity.status(200).body(patients);
	}
	
	//Display Patient Count
	@GetMapping("/count")
	public ResponseEntity<String> displayPatientCount()
	{
		Long count = service.displayPatientCount();
		String msg = "Total Patients = "+count;
		return ResponseEntity.ok(msg);
	}
}