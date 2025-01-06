package com.accenture.docbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.docbook.model.Patient;
import com.accenture.docbook.service.PatientService;


@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	
	@GetMapping("/{patientId}")
	public Patient getPatientById(@PathVariable Long patientId) {
		return patientService.getPatientById(patientId);
	}
	
	@PostMapping("/add")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
	
	@GetMapping
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
}
