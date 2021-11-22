package com.training.TaskManager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.repository.EmployeeRepository;
import com.training.TaskManager.repository.ManagerRepository;

@Service
public class ManagerDetailsService implements UserDetailsService {

	@Autowired
	private ManagerRepository mrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ManagerInfo mng = mrepo.findByEmail(username);
		
		if(mng == null)
			throw new UsernameNotFoundException("Manager 404");
		
		ManagerPrincipal e = new ManagerPrincipal(mng);
		return e;
	}

}
