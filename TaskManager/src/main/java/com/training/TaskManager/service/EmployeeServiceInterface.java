package com.training.TaskManager.service;

import java.util.List;

import com.training.TaskManager.model.EmployeeInfo;
import com.training.TaskManager.model.TaskInfo;

public interface EmployeeServiceInterface 
{
	public boolean saveOrUpdate(EmployeeInfo emp);
	
	public List<EmployeeInfo> getAllEmployees();
	
	public EmployeeInfo findByEmail(String email);
	
	public void addTask(TaskInfo tinfo,EmployeeInfo empinfo);
}
