package com.accenture.docbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.docbook.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	Patient findByUsername(String username); 
}
