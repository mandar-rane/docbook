package com.accenture.docbook.model;

import java.time.LocalDateTime;

import com.accenture.docbook.utils.AppointmentStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


public class AppointmentRequest {
	
	
	private LocalDateTime date;

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}


	public Long patientId;


	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}


	private Long doctorId;
    
	
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;
	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
	

}
