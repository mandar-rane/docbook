package com.accenture.docbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.docbook.model.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	@Modifying
	@Query(
			value="UPDATE Doctor SET name = ?1 WHERE id = ?2",
			nativeQuery = true
			)
	int updateDoctorNameById(String name, Long id);
}
