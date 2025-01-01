package com.accenture.docbook.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.accenture.docbook.model.Appointment;
import com.accenture.docbook.model.AppointmentRequest;
import com.accenture.docbook.model.Doctor;
import com.accenture.docbook.model.Patient;
import com.accenture.docbook.repository.AppointmentRepository;
import com.accenture.docbook.repository.DoctorRepository;
import com.accenture.docbook.service.AppointmentService;
import com.accenture.docbook.service.DoctorService;
import com.accenture.docbook.service.PatientService;
import com.accenture.docbook.utils.AppointmentStatus;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@Autowired
	PatientService patientService;

	@Autowired
	DoctorService doctorService;

	@PostMapping("/add")
	public Appointment addAppointment(@RequestBody AppointmentRequest appointmentRequest) {

		Doctor doctor = doctorService.getDoctorById(appointmentRequest.getDoctorId());
		Patient patient = patientService.getPatientById(appointmentRequest.getPatientId());

		Appointment appointment = new Appointment();

		appointment.setDate(appointmentRequest.getDate());
		appointment.setDoctor(doctor);

		appointment.setPatient(patient);
		appointment.setStatus(AppointmentStatus.valueOf(appointmentRequest.getStatus().name()));

		return appointmentService.addAppointment(appointment);
	}

	@GetMapping("/all/{id}")
	public List<Appointment> getAllAppointmentsByDoctorId(@PathVariable Long id) {
		return appointmentService.getAppointmentsByDoctorId(id);
	}

	@GetMapping("/all/{id}/count")
	public Integer getAppointmentsCountByDoctorId(@PathVariable Long id) {
		return appointmentService.getAppointmentCountByDoctorId(id);
	}
}
