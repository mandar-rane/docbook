package com.accenture.docbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.docbook.model.Appointment;
import com.accenture.docbook.model.Doctor;
import com.accenture.docbook.repository.AppointmentRepository;
import com.accenture.docbook.repository.DoctorRepository;

import jakarta.transaction.Transactional;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public Doctor getDoctorById(Long doctorId) {
		return doctorRepository.findById(doctorId)
				.orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId));
	}
	
	@Transactional
	public Integer updateDoctorNameById(String name, Long doctorId) {
		return doctorRepository.updateDoctorNameById(name, doctorId);
	}

}
