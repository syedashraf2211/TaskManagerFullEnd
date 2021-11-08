package com.training.TaskManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.training.TaskManager.model.ManagerInfo;
import com.training.TaskManager.model.TaskInfo;
import com.training.TaskManager.repository.ManagerRepository;
import com.training.TaskManager.repository.TaskRepository;

@Service
public class ManagerService implements ManagerServiceInterface{

	@Autowired
	private ManagerRepository managerrepo;
	
	@Autowired
	private TaskRepository taskrepo;
	
	@Override
	public void saveOrUpdate(ManagerInfo manager) 
	{
		managerrepo.save(manager);
	}

	@Override
	public ManagerInfo findByEmail(String email) {
		
		ManagerInfo manager = managerrepo.findByEmail(email);
		return manager;
	}
	
	public boolean validateCredentials(String email, String password)
	{
		ManagerInfo manager = findByEmail(email);
		return (manager.getEmail().equals(email)&& manager.getPassword().equals(password));
	}
	
	public void saveTask(TaskInfo task)
	{
		taskrepo.save(task);
	}

}
