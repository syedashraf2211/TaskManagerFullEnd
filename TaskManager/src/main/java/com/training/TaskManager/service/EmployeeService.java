package com.training.TaskManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.repository.EmployeeRepository;
import com.training.TaskManager.repository.TaskRepository;

@Service
@Component
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeRepository repo;
	
	
	
	@Override
	public void saveOrUpdate(EmployeeInfo emp) {
		repo.save(emp);
	}

	/*
	@Override
	public EmployeeInfo findByEmail(String email) {
		// TODO Auto-generated method stub
		EmployeeInfo emp = repo.findByEmail(email);
		return emp;
	}

	
	public boolean validateEmployee(String email,String password)
	{
		EmployeeInfo emp = findByEmail(email);
		return (emp.getEmail().equals(email) && emp.getPassword().equals(password));
		
	}*/
}
