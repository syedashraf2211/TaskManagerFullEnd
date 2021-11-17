package com.training.TaskManager.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.training.TaskManager.model.EmployeeInfo;

public class EmployeePrincipal implements UserDetails {

	private EmployeeInfo empinfo;
	
	
	
	public EmployeePrincipal(EmployeeInfo empinfo) {
		super();
		this.empinfo = empinfo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("EMPLOYEE"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return empinfo.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return empinfo.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
