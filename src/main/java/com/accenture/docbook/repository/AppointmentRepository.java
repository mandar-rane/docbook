package com.accenture.docbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.docbook.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	List<Appointment> findAppointmentsByDoctorId(Long doctorId);
	
	
	//JPQL
	@Query("SELECT count(a) FROM Appointment a WHERE a.doctor.id = ?1")
	Integer getAppointmentCountByDoctorId(Long doctorId);
	
	
	//NATIVE WITH NAMED PARAM
	@Query(
			value = "SELECT count(*) FROM Appointment WHERE doctor_id = :doctorId",
			nativeQuery = true
			)
	Integer getAppointmentCountByDoctorIdNative(@Param("doctorId") Long doctorId);
	
}
