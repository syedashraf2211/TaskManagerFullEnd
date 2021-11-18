package com.training.TaskManager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.repository.ManagerRepository;

public class ManagerDetailsService implements UserDetailsService{

	@Autowired
	ManagerRepository mrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		ManagerInfo minfo = mrepo.findByEmail(username);
		ManagerPrincipal mpr = new ManagerPrincipal(minfo);
		return mpr;
	}

}
