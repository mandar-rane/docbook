package com.accenture.docbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.accenture.docbook.repository.AppointmentRepository;
import com.accenture.docbook.model.Appointment;
import com.accenture.docbook.model.Doctor;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Appointment addAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	public List<Appointment> getAppointmentsByDoctorId(Long doctorId){
		return appointmentRepository.findAppointmentsByDoctorId(doctorId);
	}
	
	public Integer getAppointmentCountByDoctorId(Long doctorId) {
		return appointmentRepository.getAppointmentCountByDoctorIdNative(doctorId);
	}

}
