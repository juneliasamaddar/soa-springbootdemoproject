package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Patient;
import com.klef.soa.service.PatientService;

import jakarta.annotation.PostConstruct;

@RestController
//or
//@Controller->this return a page
//ResponseBody()->this will return data 
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	@GetMapping("/")
	public String test(){
		return "SOP Programming & Microservices";
	}
	
	@GetMapping("/displayall")
	public ResponseEntity<List<Patient>> dispalyallpatients() {
		List<Patient> patients=service.displayAllPatients();
		return ResponseEntity.status(200).body(patients);
		//200->success
	}
    
	@PostMapping("/add")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient p) {//@RequestBody means client to server telling server thatt client will give json input
		Patient patient=service.addPatient(p);
		return ResponseEntity.status(201).body(patient);
		//201->created
	}
	
}