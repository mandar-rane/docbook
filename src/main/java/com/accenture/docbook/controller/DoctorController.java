package com.accenture.docbook.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.docbook.model.Doctor;
import com.accenture.docbook.repository.DoctorRepository;
import com.accenture.docbook.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/all")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
	@PostMapping("/add")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}
	
	@PutMapping("/updateName")
	public Integer updateDoctorName(@RequestBody Map<String, Object> requestBody) {
		Long id = Long.valueOf(requestBody.get("id").toString());
		String name = requestBody.get("name").toString();
		
		return doctorService.updateDoctorNameById(name, id);
	}
	
	
}