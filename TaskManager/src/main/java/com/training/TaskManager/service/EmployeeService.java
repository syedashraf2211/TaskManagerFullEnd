package com.training.TaskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.training.TaskManager.model.EmployeeDTO;
import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.TaskInfo;
import com.training.TaskManager.repository.EmployeeRepository;
import com.training.TaskManager.repository.TaskRepository;
import com.training.TaskManager.security.EmployeePrincipal;

@Service
//@Component
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeRepository repo;
	
	
	
	@Override
	public boolean saveOrUpdate(EmployeeDTO emp) {
		
		EmployeeInfo einfo = findByEmail(emp.getEmail());
		if(einfo != null)
			return false;
		String password = emp.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedpassword = passwordEncoder.encode(password);
		emp.setPassword(encodedpassword);
		EmployeeInfo empinfo = emp.toEntity(emp);
		repo.save(empinfo);
		return true;
	}



	@Override
	public List<EmployeeInfo> getAllEmployees() {

		return repo.findAll();
	}
	
	
	@Override
	public EmployeeInfo findByEmail(String email) {

		return repo.findByEmail(email);
	}



	@Override
	public void addTask(TaskInfo tinfo,EmployeeInfo empinfo) {
		empinfo.getTasks().add(tinfo);
	}



	@Override
	public void deleteTask(TaskInfo tinfo, EmployeeInfo empinfo) {

		empinfo.getTasks().remove(tinfo);
		
	}


	
	/*
	public boolean validateEmployee(String email,String password)
	{
		EmployeeInfo emp = findByEmail(email);
		return (emp.getEmail().equals(email) && emp.getPassword().equals(password));
		
	}*/
}
