package com.accenture.docbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.accenture.docbook.model.Patient;
import com.accenture.docbook.model.UserPrincipal;
import com.accenture.docbook.repository.PatientRepository;

public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Patient patient = patientRepository.findByUsername(username);
		
		if(patient == null) {
			System.out.println("Patient Not Found");
			throw new UsernameNotFoundException("User not found");	
		}
		
		return new UserPrincipal(patient);
	}

}
