package com.accenture.docbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.docbook.model.Patient;
import com.accenture.docbook.repository.PatientRepository;


@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	public Patient getPatientById(Long patientId) {
		return patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient Not Found: " + patientId));
	}
	
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}

}
