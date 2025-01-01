package com.accenture.docbook.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}
	
	private Patient patient;

	public UserPrincipal(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return patient.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return patient.getUsername();
	}
	
	@Override 
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override 
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override 
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override 
	public boolean isEnabled() {
		return true;
	}

}
