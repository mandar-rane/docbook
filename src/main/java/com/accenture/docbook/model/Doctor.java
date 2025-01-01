package com.accenture.docbook.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
    private String specialty;
	
	@Column(unique = true,nullable = false)
    private String email;
	
    @Column(nullable = false)
    private String clinicAddress;
	
    @Column(nullable = false)
    private double fee;
    
    @Column(nullable = false)
    private int experience;

    private String availabilitySchedule;
}
