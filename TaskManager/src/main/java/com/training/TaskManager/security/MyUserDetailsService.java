package com.training.TaskManager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.repository.EmployeeRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepository erepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		EmployeeInfo emp = erepo.findByEmail(username);
		
		if(emp == null)
			throw new UsernameNotFoundException("Employee 404");
		
		EmployeePrincipal e = new EmployeePrincipal(emp);
		return e;
	}

}
