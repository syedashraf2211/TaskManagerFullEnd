package com.training.TaskManager.service;

import java.util.List;

import com.training.TaskManager.model.EmployeeInfo;

public interface EmployeeServiceInterface 
{
	public void saveOrUpdate(EmployeeInfo emp);
	
	public List<EmployeeInfo> getAllEmployees();
	
	//public EmployeeInfo findByEmail(String email);
}
