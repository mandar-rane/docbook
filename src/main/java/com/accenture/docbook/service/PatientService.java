package com.accenture.docbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.accenture.docbook.model.Patient;
import com.accenture.docbook.repository.PatientRepository;


@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public Patient getPatientById(Long patientId) {
		return patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient Not Found: " + patientId));
	}
	
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	public Patient addPatient(Patient patient){
		patient.setPassword(encoder.encode(patient.getPassword()));
		return patientRepository.save(patient);
	}

}
